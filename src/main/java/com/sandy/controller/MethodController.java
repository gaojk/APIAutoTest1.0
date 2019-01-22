package com.sandy.controller;


import com.alibaba.fastjson.JSONObject;
import com.sandy.domain.App;
import com.sandy.domain.Method;
import com.sandy.domain.Testcase;
import com.sandy.domain.User;
import com.sandy.service.AppService;
import com.sandy.service.CaseService;
import com.sandy.service.MethodService;
import com.sandy.utils.HttpUtils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ResourceController
 * @Author sandy.n.hao
 * @Date: 2019/01/15
 * @Version v1.0.0
 * @Description: //TODO
 */


@Controller
@SessionAttributes("user")
@RequestMapping("/method/action")
public class MethodController {

    @Autowired
    private MethodService methodService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private AppService appService;

    @ResponseBody
    @RequestMapping(value="/run",method = RequestMethod.POST)
    public Map<Long, String> MethodSaveController(User user,
                                                  @RequestParam(value = "env")String env,
                                                  @RequestParam(value = "port")String port,
                                                  @RequestParam(value = "appid")Long appId,
                                                  @RequestParam(value = "selectedmethod[]", required=false, defaultValue = "")Integer[] selectedmethod)
    {

        Map<Long,String> result = new HashMap<>();

        //获取当前登录用户
//        List<App> app = appService.getAppByUserId(user.getSysno());


        for(int i=0; i<selectedmethod.length; i++){


            Long methodId = Long.parseLong(String.valueOf(selectedmethod[i]));
            Method method = methodService.getMethodsByMethodId(methodId);
            List<Testcase> testcases = caseService.getCaseByMethodIdAndUserId(methodId,user.getSysno());
            App app = appService.getAppByAppId(appId);

            for(int j=0; j<testcases.size(); j++){
                //组装
                HttpRequestUtil.GeneHttpRequestUtil(method.getMethod(),testcases.get(j).getContent(),
                        app.getAppId(),app.getAppSecret());

                //执行
                result.put(methodId,HttpRequestUtil.ExeHttpRequestUtil(env, port));
            }

        }

        return result;

    }

    @ResponseBody
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Map<Long, String> MethodRunController(User user,
                                                 @RequestParam(value = "selectedcase[]", required=false, defaultValue = "")String[] selectedcase) throws IOException {

        JSONObject object;
        Long methodId;
        String content;
        Map<Long,String> result = new HashMap<>();
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decoding;
        List<Testcase> testcases;



        for(int i=0; i<selectedcase.length; i++)
        {

            decoding = decoder.decodeBuffer(selectedcase[i]);
            String selectedcasestr = new String(decoding, StandardCharsets.UTF_8);

            object = JSONObject.parseObject(selectedcasestr);
            methodId = object.getLong("id");
            content = object.getString("param");

            if(content != null)
            {
                testcases = caseService.getCaseByMethodIdAndUserId(methodId,user.getSysno());

                if(testcases.size() == 0 ){
                    caseService.insertCase(methodId,user.getSysno(),content);
                }
                else{
                    caseService.updateCaseByMethodIdAndUserId(methodId, user.getSysno(), content);
                }

                testcases = caseService.getCaseByMethodIdAndUserId(methodId,user.getSysno());

                for(int j=0; j<testcases.size(); j++){

                    result.put(methodId,testcases.get(j).getContent());

                }
            }

        }
        return result;
    }

}
