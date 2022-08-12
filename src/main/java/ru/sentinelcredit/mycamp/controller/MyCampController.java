package ru.sentinelcredit.mycamp.controller;

import com.cck.genesys4j.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sentinelcredit.mycamp.model.MyCampPersonAgentGroupsApiResponse;
import ru.sentinelcredit.mycamp.service.MyCampService;

import java.util.Collection;

@Slf4j
@RestController
public class MyCampController {

    @Autowired
    private MyCampService myCampService;

    @GetMapping("/mycamp/createCampaign")
    public ObjectIdApiResponse createCampaign(@RequestParam String guid, @RequestParam String name, @RequestParam Integer callListId, Integer path) {
        log.trace("createCampaign start with guid => '{}' name => '{}' callListId => '{}' path => '{}'", guid, name, callListId, path);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createCampaign(name, callListId, path);
        log.trace("createCampaign end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/dropCampaign")
    public BaseApiResponse dropCampaign(@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropCampaign start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropCampaign(id);
        log.trace("dropCampaign end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryCampaign")
    public ObjectIdApiResponse queryCampaign(@RequestParam String guid, @RequestParam String name) {
        log.trace("queryCampaign start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.queryCampaign(name);
        log.trace("queryCampaign end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/startCampaign")
    public BaseApiResponse startCampaign(@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer groupId, String dialingMode, String optimizationMethod, Integer optimizedGoal) {
        log.trace("startCampaign start with guid => '{}' id => '{}' groupId => '{}' dialingMode => '{}' optimizationMethod => '{}' optimizedGoal => '{}'", guid, id, groupId, dialingMode, optimizationMethod, optimizedGoal);
        BaseApiResponse baseApiResponse = myCampService.startCampaign(id, groupId, dialingMode, optimizationMethod, optimizedGoal);
        log.trace("startCampaign end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }
    
    @GetMapping("/mycamp/stopCampaign")
    public BaseApiResponse stopCampaign(@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer groupId) {
        log.trace("stopCampaign start with guid => '{}' id => '{}' personId => '{}'", guid, id, groupId);
        BaseApiResponse baseApiResponse = myCampService.stopCampaign(id, groupId);
        log.trace("stopCampaign end with code => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }    

    @GetMapping("/mycamp/createCallList")
    public ObjectIdApiResponse createCallList (@RequestParam String guid, @RequestParam String name, @RequestParam Integer tableAccessId,
                                               @RequestParam String filterName, @RequestParam Integer maxAttempts, @RequestParam Integer timeFrom,
                                               @RequestParam Integer timeUntil, @RequestParam Collection<String> treatmentsName,
                                               @RequestParam(defaultValue = "101") Integer tenantId, @RequestParam Integer path) {
        log.trace("dropCampaign start with guid => '{}' name => '{}' tableAccessId => '{}' filterName => '{}' maxAttempts => '{}' timeFrom => '{}' timeUntil => '{}' treatmentsName => '{}' tenantId => '{}' path => '{}'", guid, name, tableAccessId, filterName, maxAttempts, timeFrom, timeUntil, treatmentsName, tenantId, path);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createCallList(name, tableAccessId, filterName, maxAttempts, timeFrom,
                timeUntil, treatmentsName, tenantId, path);
        log.trace("dropCampaign end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/dropCallList")
    public BaseApiResponse dropCallList (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropCallList start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropCallList(id);
        log.trace("dropCallList end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryCallList")
    public ObjectIdApiResponse queryCallList (@RequestParam String guid, @RequestParam String name) {
        log.trace("queryCallList start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.queryCallList(name);
        log.trace("queryCallList end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/createTableAccess")
    public ObjectIdApiResponse createTableAccess (@RequestParam String guid, @RequestParam String name, @RequestParam String dbAccessPoint,
                                                  @RequestParam String formatName, @RequestParam String tableName,
                                                  @RequestParam(defaultValue = "101") Integer tenantId, @RequestParam Integer path) {
        log.trace("createTableAccess start with guid => '{}' name => '{}' dbAccessPoint => '{}' formatName => '{}' tableName => '{}' ", guid, name, dbAccessPoint, formatName, tableName, tenantId, path);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createTableAccess(name, dbAccessPoint, formatName, tableName, tenantId, path);
        log.trace("CreateTableAccess end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/dropTableAccess")
    public BaseApiResponse dropTableAccess (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropTableAccess start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropTableAccess(id);
        log.trace("dropTableAccess end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryTableAccess")
    public ObjectIdApiResponse queryTableAccess (@RequestParam String guid, @RequestParam String name) {
        log.trace("queryTableAccess start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.queryTableAccess(name);
        log.trace("queryTableAccess end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/createCampaignGroup")
    public ObjectIdApiResponse createCampaignGroup (@RequestParam String guid, @RequestParam String name, @RequestParam Integer campaignId,
                                                    @RequestParam Integer agentGroupId, String dialingMode, String voiceTransferDestination, String trunkGroupDN,
                                                    String operationMode, String optimizationMethod, Integer targetValue, Integer bufferSizeMinimum,
                                                    Integer bufferSizeOptimum, Integer numberCPDPorts, @RequestParam Collection<String> connections,
                                                    @RequestParam Collection<String> annexOption) {
        log.trace("createCampaignGroup start with guid => '{}' name => '{}' campaignId => '{}' agentGroupId => '{}' dialingMode => '{}' voiceTransferDestination => '{}' trunkGroupDN => '{}' operationMode => '{}' optimizationMethod => '{}' targetValue => '{}' bufferSizeMinimum => '{}' bufferSizeOptimum => '{}' numberCPDPorts => '{}' connections => '{}' annexOption => '{}'", guid, name, campaignId, agentGroupId, dialingMode, voiceTransferDestination, trunkGroupDN, operationMode, optimizationMethod, targetValue,
            bufferSizeMinimum, bufferSizeOptimum, numberCPDPorts, connections, annexOption);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createCampaignGroup(name, campaignId, agentGroupId, dialingMode, voiceTransferDestination, trunkGroupDN, operationMode, optimizationMethod, targetValue,
            bufferSizeMinimum, bufferSizeOptimum, numberCPDPorts, connections, annexOption);
        log.trace("createCampaignGroup end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }
    
    @GetMapping("/mycamp/dropCampaignGroup")
    public BaseApiResponse dropCampaignGroup (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropCampaignGroup start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropCampaignGroup(id);
        log.trace("dropCampaignGroup end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryCampaignGroup")
    public ObjectIdApiResponse queryCampaignGroup (@RequestParam String guid, @RequestParam String name) {
        log.trace("queryCampaignGroup start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.queryCampaignGroup(name);
        log.trace("dropCampaignGroup end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/createSkill")
    public ObjectIdApiResponse createSkill (@RequestParam String guid, @RequestParam String name, @RequestParam(defaultValue = "101") Integer tenantId,
                                            @RequestParam Integer path) {
        log.trace("createSkill start with guid => '{}' name => '{}' tenantId => '{}' path => '{}'", guid, name, tenantId, path);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createSkill(name, tenantId, path);
        log.trace("createSkill end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;   
    }
    
    @GetMapping("/mycamp/dropSkill")
    public BaseApiResponse dropSkill (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropSkill start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropSkill(id);
        log.trace("dropSkill end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/querySkill")
    public ObjectIdApiResponse querySkill (@RequestParam String guid, @RequestParam String name) {
        log.trace("querySkill start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.querySkill(name);
        log.trace("querySkill end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/queryCfgPerson")
    public PersonApiResponse queryCfgPerson(@RequestParam String guid, @RequestParam String login) {
        log.trace("queryCfgPerson start with guid => '{}' login => '{}'", guid, login);
        PersonApiResponse personApiResponse = myCampService.queryCfgPerson(login);
        log.trace("queryCfgPerson end with code => '{}' message => '{}'", personApiResponse.getErrorCode(), personApiResponse.getErrorMessage());
        return personApiResponse;
    }

    @GetMapping("/mycamp/createAgentGroup")
    public ObjectIdApiResponse createAgentGroup (@RequestParam String guid, @RequestParam String name, @RequestParam String script,
                                                 @RequestParam(defaultValue = "101") Integer tenantId, @RequestParam Integer path) {
        log.trace("createAgentGroup start with guid => '{}' name => '{}' script => '{}' tenantId => '{}' path => '{}'", guid, name, script, tenantId, path);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createAgentGroup(name, script, tenantId, path);
        log.trace("createAgentGroup end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/dropAgentGroup")
    public BaseApiResponse dropAgentGroup (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropAgentGroup start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropAgentGroup(id);
        log.trace("dropAgentGroup end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryAgentGroup")
    public ObjectIdApiResponse queryAgentGroup (@RequestParam String guid, @RequestParam String name) {
        log.trace("queryAgentGroup start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.queryAgentGroup(name);
        log.trace("queryAgentGroup end with code => '{}' message = '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/queryAgentGroups")
    public MyCampPersonAgentGroupsApiResponse queryAgentGroups (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("queryAgentGroups start with guid => '{}' id => '{}'", guid, id);
        MyCampPersonAgentGroupsApiResponse myCampPersonAgentGroupsApiResponse = myCampService.queryAgentGroups(id);
        log.trace("queryAgentGroups end with code => '{}' message = '{}'", myCampPersonAgentGroupsApiResponse.getErrorCode(), myCampPersonAgentGroupsApiResponse.getErrorMessage());
        //return personAgentGroupsApiResponse;
        return myCampPersonAgentGroupsApiResponse;
    }

    @GetMapping("/mycamp/addAgentToGroup")
    public BaseApiResponse addAgentToGroup (@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer personId) {
        log.trace("addAgentToGroup start with guid => '{}' id => '{}' personId => '{}'", guid, id, personId);
        BaseApiResponse baseApiResponse = myCampService.addAgentToGroup(id, personId);
        log.trace("addAgentToGroup end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/deleteAgentFromGroup")
    public BaseApiResponse deleteAgentFromGroup (@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer personId) {
        log.trace("deleteAgentFromGroup start with guid => '{}' id => '{}' personId => '{}'", guid, id, personId);
        BaseApiResponse baseApiResponse = myCampService.deleteAgentFromGroup(id, personId);
        log.trace("deleteAgentFromGroup end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/createVirtualQueue")
    public ObjectIdApiResponse createVirtualQueue (@RequestParam String guid, @RequestParam String name, @RequestParam String switchName,
                                                   @RequestParam Integer path) {
        log.trace("createVirtualQueue start with guid => '{}' name => '{}' switchName => '{}' path => '{}'", guid, name, switchName, path);
        ObjectIdApiResponse objectIdApiResponse = myCampService.createVirtualQueue(name, switchName, path);
        log.trace("createVirtualQueue end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/dropVirtualQueue")
    public BaseApiResponse dropVirtualQueue (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("dropVirtualQueue start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropVirtualQueue(id);
        log.trace("dropVirtualQueue end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryVirtualQueue")
    public ObjectIdApiResponse queryVirtualQueue (@RequestParam String guid, @RequestParam String name) {
        log.trace("queryVirtualQueue start with guid => '{}' name => '{}'", guid, name);
        ObjectIdApiResponse objectIdApiResponse = myCampService.queryVirtualQueue(name);
        log.trace("queryVirtualQueue end with code => '{}' message => '{}'", objectIdApiResponse.getErrorCode(), objectIdApiResponse.getErrorMessage());
        return objectIdApiResponse;
    }

    @GetMapping("/mycamp/updatePersonParam")
    public BaseApiResponse updateUserParam(@RequestParam String guid, @RequestParam Integer id, @RequestParam String key, String value) {
        log.trace("updatePersonParam start with guid => '{}' id => '{}' key => '{}' value => '{}'", guid, id, key, value);
        BaseApiResponse baseApiResponse = myCampService.updatePersonParam(id, key, value);
        log.trace("updatePersonParam end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }
    
    @GetMapping("/mycamp/dropPersonParam")
    public BaseApiResponse dropUserParam (@RequestParam String guid, @RequestParam Integer id, @RequestParam String key) {
        log.trace("dropPersonParam start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.dropPersonParam(id, key);
        log.trace("dropPersonParam end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }
    
    @GetMapping("/mycamp/queryPersonParam")
    public PersonParamApiResponse queryPersonParam (@RequestParam String guid, @RequestParam Integer id, @RequestParam String key) {
        log.trace("queryPersonParam start with guid => '{}' id => '{}' key => '{}'", guid, id, key);
        PersonParamApiResponse personParamApiResponse = myCampService.queryPersonParam(id, key);
        log.trace("queryPersonParam end with code => '{}' message => '{}'", personParamApiResponse.getErrorCode(), personParamApiResponse.getErrorMessage());
        return personParamApiResponse;
    }

    @GetMapping("/mycamp/dropPersonProperty")
    public BaseApiResponse dropPersonProperty (@RequestParam String guid, @RequestParam Integer id, @RequestParam String sectionName, @RequestParam String key) {
        log.trace("dropPersonProperty start with guid => '{}' id => '{}' sectionName => '{}' key => '{}'", guid, id, sectionName, key);
        BaseApiResponse baseApiResponse = myCampService.dropPersonProperty(id, sectionName, key);
        log.trace("dropPersonProperty end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/createTable")
    public BaseApiResponse createTable (@RequestParam String guid, @RequestParam Integer id) {
        log.trace("createTable start with guid => '{}' id => '{}'", guid, id);
        BaseApiResponse baseApiResponse = myCampService.createTable(id);
        log.trace("createTable end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/addSkillToAgent")
    public BaseApiResponse addSkillToAgent (@RequestParam String guid, @RequestParam Integer id, @RequestParam String skillLevelName, @RequestParam Integer skillLevelKey) {
        log.trace("addSkillToAgent start with guid => '{}' id => '{}' skillLevelName => '{}' skillLevelKey => '{}'", guid, id, skillLevelName, skillLevelKey);
        BaseApiResponse baseApiResponse = myCampService.addSkillToAgent(id, skillLevelName, skillLevelKey);
        log.trace("addSkillToAgent end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/dropSkillFromAgent")
    public BaseApiResponse dropSkillFromAgent (@RequestParam String guid, @RequestParam Integer id, @RequestParam String skillLevelName) {
        log.trace("dropSkillFromAgent start with guid => '{}' id => '{}' skillLevelName => '{}'", guid, id, skillLevelName);
        BaseApiResponse baseApiResponse = myCampService.dropSkillFromAgent(id, skillLevelName);
        log.trace("dropSkillFromAgent end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/updatePersonProperty")
    public BaseApiResponse updatePersonProperty (@RequestParam String guid, @RequestParam Integer id, @RequestParam String sectionName,  @RequestParam String key, @RequestParam String value) {
        log.trace("updatePersonProperty start with guid => '{}' id => '{}' sectionName => '{}' key => '{}' value => '{}'", guid, id, sectionName, key, value);
        BaseApiResponse baseApiResponse = myCampService.updatePersonProperty(id, sectionName, key, value);
        log.trace("updatePersonProperty end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/queryPersonProperty")
    public PersonParamApiResponse queryPersonProperty (@RequestParam String guid, @RequestParam Integer id, @RequestParam String sectionName, @RequestParam String key) {
        log.trace("queryPersonProperty start with guid => '{}' id => '{}' attributeName => '{}' sectionName => '{}' key => '{}'", guid, id, sectionName, key);
        PersonParamApiResponse personParamApiResponse = myCampService.queryPersonProperty(id, sectionName, key);
        log.trace("queryPersonProperty end with code => '{}' message => '{}'", personParamApiResponse.getErrorCode(), personParamApiResponse.getErrorMessage());
        return personParamApiResponse;
    }

    @GetMapping("/mycamp/getCampaignStatus")
    public CampaingStatusApiResponse getCampaignStatus (@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer groupId) {
        log.trace("getCampaignStatus start with guid => '{}' id => '{}' groupId => '{}'", guid, id, groupId);
        CampaingStatusApiResponse campaingStatusApiResponse = myCampService.getCampaignStatus(id, groupId);
        log.trace("getCampaignStatus end with code => '{}' message => '{}'", campaingStatusApiResponse.getErrorCode(), campaingStatusApiResponse.getErrorMessage());
        return campaingStatusApiResponse;
    }

    @GetMapping("/mycamp/loadCampaign")
    public BaseApiResponse loadCampaign (@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer groupId) {
        log.trace("loadCampaign start with guid => '{}' id => '{}' groupId => '{}'", guid, id, groupId);
        BaseApiResponse baseApiResponse = myCampService.loadCampaign(id, groupId);
        log.trace("loadCampaign end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }

    @GetMapping("/mycamp/unloadCampaign")
    public BaseApiResponse unloadCampaign (@RequestParam String guid, @RequestParam Integer id, @RequestParam Integer groupId) {
        log.trace("unloadCampaign start with guid => '{}' id => '{}' groupId => '{}'", guid, id, groupId);
        BaseApiResponse baseApiResponse = myCampService.unloadCampaign(id, groupId);
        log.trace("unloadCampaign end with code => '{}' message => '{}'", baseApiResponse.getErrorCode(), baseApiResponse.getErrorMessage());
        return baseApiResponse;
    }
}
