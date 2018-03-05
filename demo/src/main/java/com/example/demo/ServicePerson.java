package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.sql.Types;
/**
 * Created by martin on 27/6/2017.
 */
@Component
public class ServicePerson {

    private final Logger logger = LoggerFactory.getLogger(ServicePerson.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void callProcedureTest(ControlFiles controlFiles){
        logger.warn("Llamando al procedure - P_CONTROL_FILES("+controlFiles.getTable_raw_name()+","+controlFiles.getProject_name()+")");
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("P_CONTROL_FILES")
                .declareParameters(
                        new SqlParameter("P_TABLE_RAW_NAME", Types.VARCHAR),
                        new SqlParameter("P_PROJECT_NAME",Types.VARCHAR)
                        );

       //call.execute(controlFiles.getTable_raw_name(),controlFiles.getProject_name()
        try{
            call.execute(controlFiles.getTable_raw_name(),controlFiles.getProject_name()

//                new MapSqlParameterSource("P_TABLE_RAW_NAME",controlFiles.getTable_raw_name()),
//                new MapSqlParameterSource("P_PROJECT_NAME",controlFiles.getProject_name())
            );
        }catch (IndexOutOfBoundsException ex){
            logger.error("Errr tipo IndexOutOfBoundsException: "+ex.toString());
        } catch (Exception ex){
            logger.error(ex.toString());
        }

        logger.info("TERMINANDO callProcedureTest............");
    }

//    @Async
//    public CompletableFuture<Person> createPerson(int id) throws InterruptedException {
//        Person results = new Person(id,"Martin","Champarini");
//        Thread.sleep(1000L);
//        System.out.println("Task done !! by "+Thread.currentThread().getName()+" task: create..."+results.toString());
//        return CompletableFuture.completedFuture(results);
//    }
//
//    @Async
//    public CompletableFuture<Person> createPerson2(int id) throws InterruptedException {
//        Person results = new Person(id,"Martin","Champarini");
//        Thread.sleep(5000L);
//        System.out.println("Task done !! by "+Thread.currentThread().getName()+" task: create..."+results.toString());
//        return CompletableFuture.completedFuture(results);
//    }
}
