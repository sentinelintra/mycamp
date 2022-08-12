package ru.sentinelcredit.mycamp.model;

import com.cck.genesys4j.model.*;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentGroup;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class MyCampPersonAgentGroupsApiResponse extends BaseApiResponse {
    private Collection<MyCampCfgAgentGroup> agentGroups;

	public MyCampPersonAgentGroupsApiResponse (PersonAgentGroupsApiResponse personAgentGroupsApiResponse) {
		super(personAgentGroupsApiResponse.getErrorCode(), personAgentGroupsApiResponse.getErrorMessage());
		if (getErrorCode() == 0 && personAgentGroupsApiResponse.getAgentGroups() != null) {
			agentGroups = new LinkedList();
			Iterator<CfgAgentGroup> i = personAgentGroupsApiResponse.getAgentGroups().iterator();
			while (i.hasNext()) {
				CfgAgentGroup agentGroup = i.next();
				this.agentGroups.add(new MyCampCfgAgentGroup(agentGroup.getGroupInfo().getDBID(), agentGroup.getGroupInfo().getName()));
			}
		}
	}

	public String getAgentGroupsStr() {
		String s = "";

		if (agentGroups != null) {
			Iterator<MyCampCfgAgentGroup> i = agentGroups.iterator();
			while (i.hasNext()) {
				MyCampCfgAgentGroup myCampCfgAgentGroup = i.next();
				if (s.length() > 0) s += ",";
				s += "(dbid_" + myCampCfgAgentGroup.getDbid() + ",name_" + myCampCfgAgentGroup.getName() + ")";
			}
		}

		return s;
	}
	
	public Collection<MyCampCfgAgentGroup> getAgentGroups() {
		return this.agentGroups;
	}
}
