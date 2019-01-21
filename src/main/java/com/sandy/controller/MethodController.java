package com.sandy.controller;


import com.sandy.domain.App;
import com.sandy.domain.Method;
import com.sandy.domain.Testcase;
import com.sandy.domain.User;
import com.sandy.service.AppService;
import com.sandy.service.CaseService;
import com.sandy.service.MethodService;
import com.sandy.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
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
                                                  @RequestParam(value = "selectedmethod[]", required=false, defaultValue = "")Integer[] selectedmethod)
    {

        Map<Long,String> result = new HashMap<>();

        //获取当前登录用户
        App app = appService.getAppByUserId(user.getSysno());


        for(int i=0; i<selectedmethod.length; i++){


            Long methodId = Long.parseLong(String.valueOf(selectedmethod[i]));
            Method method = methodService.getMethodsByMethodId(methodId);
            List<Testcase> testcases = caseService.getCaseByMethodIdAndUserId(methodId,user.getSysno());

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


    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String MethodRunController(User user,
                                      ModelMap modelMap,
                                      @RequestParam(value = "selectedcase", required=false, defaultValue = "")Map selectedcase)
    {

        //获取当前登录用户
        App app = appService.getAppByUserId(user.getSysno());

        Iterator iterator = selectedcase.keySet().iterator();

        while (iterator.hasNext()){

            Long methodId = (Long) iterator.next();
            String content = String.valueOf(selectedcase.get(methodId));

            caseService.updateCaseByMethodIdAndUserId(methodId, user.getSysno(), content);

        }

        return "methodlist";
    }

}
