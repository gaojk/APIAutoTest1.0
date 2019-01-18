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
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;

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

    @RequestMapping(value="/run",method = RequestMethod.POST)
    public String MethodSaveController(User user,
                                       @RequestParam(value = "env")String env,
                                       @RequestParam(value = "port")String port,
                                       @RequestParam(value = "selectedmethod")List methodids, ModelMap modelMap)
    {

        if(methodids.size() == 0){
            //alert("请勾选需要操作的方法")
            return "login";
        }

        else{

            //获取当前用户
            App app = appService.getAppByUserId(user.getSysno());

            //生成httprequest
            for(int i=0; i<methodids.size(); i++){

                Method method = methodService.getMethodsByMethodId(Long.parseLong((String) methodids.get(i)));
                List<Testcase> testcases = caseService.getCaseByMethodId(Long.parseLong((String) methodids.get(i)));

                for(int j=0; j<testcases.size(); j++){

                    //组装
                    HttpRequestUtil.GeneHttpRequestUtil(method.getMethod(),testcases.get(j).getContent(),
                            app.getAppId(),app.getAppSecret());

                    //执行
                    String result = HttpRequestUtil.ExeHttpRequestUtil(env, port);
                }

            }
            return "login";
        }

    }


    @RequestMapping(value="/save",method = RequestMethod.POST)
    public void MethodRunController(@RequestParam(value = "user")User user,
                                    @RequestParam(value = "selectmethod[]")List methodid, ModelMap modelMap)
    {

    }

}