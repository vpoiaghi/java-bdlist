package front.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import front.bean.Tsp;
import front.bean.sync_phone.SyncData;
import io.swagger.annotations.ApiOperation;
import services.ServicePhoneSync;

@RestController
public class SyncController {

    @CrossOrigin
    @RequestMapping(path = "/synchronise/load", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="return extract from database used to synchronise caller", response = SyncData.class)
    public SyncData getDatabase() {
    	
    	//RequestBody SyncTsp lastSyncTsp
    	LocalDateTime tsp = LocalDateTime.parse("2020-02-25T01:00:37");
    	Tsp lastSyncTsp = new Tsp();
    	lastSyncTsp.setTsp(tsp);
    	
    	ServicePhoneSync svcPhoneSync = new ServicePhoneSync();
    	return svcPhoneSync.getData(tsp);
    }
	
}
