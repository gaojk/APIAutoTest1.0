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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName: ResourceController
 * @Author sandy.n.hao
 * @Date: 2019/01/15
 * @Version v1.0.0
 * @Description: //TODO
 */


@Controller
@RequestMapping("/method")
public class MethodController {

    @Autowired
    private MethodService methodService;

    @Autowired
    private CaseService caseService;

    @Autowired
    private AppService appService;

    @RequestMapping(value="/run",method = RequestMethod.POST)
    public void MethodSaveController(@RequestParam(value = "user")User user,
                                     @RequestParam(value = "env")String env,
                                     @RequestParam(value = "port")String port,
                                     @RequestParam(value = "selectmethod[]")List methodids, ModelMap modelMap)
    {
        if(methodids.size() == 0){
            //alert("请勾选需要操作的方法")
        }
        else{

            HttpRequestUtil httpRequestUtil = HttpRequestUtil.getInstance();


            //获取当前用户
            App app = appService.getAppByUserId(user.getSysno());


            //生成httprequest
            for(int i=0; i<methodids.size(); i++){

                Method method = methodService.getMethodsByMethodId((Long) methodids.get(i));
                List<Testcase> testcases = caseService.getCaseByMethodId((Long) methodids.get(i));

                for(int j=0; j<testcases.size(); j++){

                    //组装
                    httpRequestUtil.GeneHttpRequestUtil(method.getMethod(),testcases.get(j).getContent(),
                            app.getAppId(),app.getAppSecret());

                    //执行
                    httpRequestUtil.ExeHttpRequestUtil(env, port);

                }

            }
        }
    }


    @RequestMapping(value="/sace",method = RequestMethod.POST)
    public void MethodRunController(@RequestParam(value = "user")User user,
                                    @RequestParam(value = "selectmethod[]")List methodid, ModelMap modelMap)
    {

    }

}
