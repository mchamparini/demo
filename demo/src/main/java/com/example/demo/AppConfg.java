package com.example.demo;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/**
 * Created by martin on 27/6/2017.
 */
@Configuration
@EnableAsync
@ComponentScan
public class AppConfg {

    @Autowired
    private Person person;

    @Autowired
    private ControlFiles controlFiles;

    @Autowired
    private ServicePerson servicePerson;


    @Bean
    public String callProcedure(){
        controlFiles.setProject_name("Project ABDC");
        controlFiles.setTable_raw_name("ABDC_RAW");

        servicePerson.callProcedureTest(controlFiles);
        return null;
    }
//    @Bean
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor threadPoolTaskExecutor =new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setMaxPoolSize(2);
//        threadPoolTaskExecutor.setThreadNamePrefix("hilo-");
//        threadPoolTaskExecutor.initialize();
//        return threadPoolTaskExecutor;
//    }

    @Bean
    public List<Person> getListoToProcess(){
        return person.personList();
    }

    @Bean
    public int setCantPerson(){
        return 10;
    }

//    @Bean
//    public String doAsyncTaskPersonList(int cantidad){
//      //  for (int i = 0; i < cantidad; i++) {
//            try {
//              CompletableFuture<Person>result1 = servicePerson.createPerson(1);
//              CompletableFuture<Person>result2 = servicePerson.createPerson2(2);
//              CompletableFuture<Person>result3 = servicePerson.createPerson(3);
//
//              CompletableFuture.allOf(result1,result3);
//                System.out.println(result1.get());
//                System.out.println(result3.get());
//                System.out.println(result2.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//
//        //}
//        return null;
//    }

}
