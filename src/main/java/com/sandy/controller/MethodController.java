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

    @ResponseBody
    @RequestMapping(value="/run",method = RequestMethod.POST)
    public String MethodSaveController(User user,
                                       @RequestParam(value = "env")String env,
                                       @RequestParam(value = "port")String port,
                                       @RequestParam(value = "selectedmethod[]",required=false, defaultValue = "")Integer[] selectedmethod)
    {

        String result = null;

        //获取当前用户
        App app = appService.getAppByUserId(user.getSysno());


        for(int i=0; i<selectedmethod.length; i++){

            Method method = methodService.getMethodsByMethodId(Long.parseLong(String.valueOf(selectedmethod[i])));
            List<Testcase> testcases = caseService.getCaseByMethodId(Long.parseLong((String.valueOf(selectedmethod[i]))));

            for(int j=0; j<testcases.size(); j++){

                //组装
                HttpRequestUtil.GeneHttpRequestUtil(method.getMethod(),testcases.get(j).getContent(),
                        app.getAppId(),app.getAppSecret());

                //执行
                result = HttpRequestUtil.ExeHttpRequestUtil(env, port);

            }

        }
        return result;


    }


    @RequestMapping(value="/save",method = RequestMethod.POST)
    public void MethodRunController(User user,
                                    @RequestParam(value = "selectmethod[]")List methodid, ModelMap modelMap)
    {

    }

}
