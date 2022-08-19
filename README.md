# mycamp

The service provides a REST API interface for managing Genesys telephony. The following calls are supported

Name                  | Description
--------------------- | -----------------------------------------------
queryTableAccess      | Querying table access
createTableAccess     | Creating table access
dropTableAccess       | Deleting table access
CreateTable           | Creating table in a database
queryCallList         | Request call list
createCallList        | Create call list
dropCallList          | Deleting call list
queryCampaign         | Campaign Request
createCampaign        | Creating campaign
dropCampaign          | Deleting campaign
startCampaign         | Starting campaign
stopCampaign          | Stopping campaign
querySkill            | Request skill
createSkill           | Create skill
dropSkill             | Delete skill
queryVirtualQueue     | Virtual queue request
createVirtualQueue    | Creating virtual queue
dropVirtualQueue      | Deleting virtual queue
queryAgentGroup       | Request to agent group
createAgentGroup      | Creating agent group
dropAgentGroup        | Deleting agent group
queryCampaignGroup    | Request campaign group
createCampaignGroup   | Create campaign group
dropCampaignGroup     | Deleting campaign group
queryCfgPerson        | Request information in CfgPerson
queryPersonProperty   | Request annex-employee properties
updatePersonProperty  | Adding/updating the employee's annex properties
dropPersonProperty    | Deleting annex-employee properties
addSkillToAgent       | Add Skill to employee
deleteAgentFromGroup  | Removing from agent group
addSkillToAgent       | Changing an employee's Skill
dropSkillFromAgent    | Remove Skill from employee
addAgentToGroup       | Add to agent group

REST API is successfully used when integrating with Oracle Siebel CRM.
