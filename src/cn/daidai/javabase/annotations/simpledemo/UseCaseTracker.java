package cn.daidai.javabase.annotations.simpledemo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Lenovo
 * @description: TODO
 * @date 2021/7/27 17:50
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for(Method m:cl.getDeclaredMethods()){
            UseCase uc =m.getAnnotation(UseCase.class);
            if(uc!=null){
                System.out.println("Found use case:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases){
            System.out.println("Warning:Missing use case-"+i);
        }

    }

    public static void main(String[] args) {
        List<Integer> userCases=new ArrayList<>();
        Collections.addAll(userCases,47,48,49,50);
        trackUseCases(userCases,PasswordUtils.class);
    }
}
