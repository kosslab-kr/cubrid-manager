/*
 * Copyright (C) 2009 Search Solution Corporation. All rights reserved by Search
 * Solution.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: -
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of the <ORGANIZATION> nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */
package com.cubrid.cubridmanager.core.broker.model;

import java.util.ArrayList;
import java.util.List;

import com.cubrid.cubridmanager.core.common.model.IModel;

/**
 * A task model for "getbrokerstatus"
 * 
 * @author lizhiqiang
 * @version 1.0 - 2009-5-19 created by lizhiqiang
 */
public class BrokerStatusInfos implements
		IModel {

	private String bname = null;
	private List<ApplyServerInfo> asInfoList;
	private List<JobInfo> jobInfoList;
	private final List<BrokerStatusInfos> subBrokerStatusInfos;

	public BrokerStatusInfos() {
		subBrokerStatusInfos = new ArrayList<BrokerStatusInfos>();
		asInfoList = new ArrayList<ApplyServerInfo>();
	}

	public String getTaskName() {
		return "getbrokerstatus";
	}

	public List<ApplyServerInfo> getAsInfo() {
		return asInfoList;
	}

	/**
	 * add asInfo
	 * 
	 * @param asInfo ApplyServerInfo
	 */
	public void addAsInfo(ApplyServerInfo asInfo) {
		if (asInfoList == null) {
			asInfoList = new ArrayList<ApplyServerInfo>();
		}
		if (!asInfoList.contains(asInfo)) {
			asInfoList.add(asInfo);
		}
	}

	/**
	 * Add the subBroker which is the instance of BrokerDiagData
	 * 
	 * @param brokerStatusInfos the instance of BrokerStatusInfos
	 */
	public void addBroker(BrokerStatusInfos brokerStatusInfos) {
		subBrokerStatusInfos.add(brokerStatusInfos);
	}

	/**
	 * Get job info
	 * 
	 * @return List<JobInfo>
	 */
	public List<JobInfo> getJobInfo() {
		return jobInfoList;
	}

	/**
	 * add jobInfo
	 * 
	 * @param jobInfo JobInfo
	 */
	public void addJobInfo(JobInfo jobInfo) {
		if (jobInfoList == null) {
			jobInfoList = new ArrayList<JobInfo>();
		}
		if (!jobInfoList.contains(jobInfo)) {
			jobInfoList.add(jobInfo);
		}
	}

	/**
	 * get the bname
	 * 
	 * @return String
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * Set the bname
	 * 
	 * @param bname the broker name
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}

	/**
	 * Get the list which include all the sub instance of BrokerDiagData
	 * 
	 * @return List<BrokerDiagData>
	 */
	public List<BrokerStatusInfos> getBrokerList() {
		return subBrokerStatusInfos;
	}

	/**
	 * Get the sub instance of BrokerDiagData by given broker name.
	 * 
	 * @param bname the broker name
	 * @return the instance of BrokerDiagData
	 */
	public BrokerStatusInfos getSubBrokerByName(String bname) {
		BrokerStatusInfos brokerStatusInfos = new BrokerStatusInfos();
		if (bname == null) {
			return brokerStatusInfos;
		}
		for (BrokerStatusInfos bdd : subBrokerStatusInfos) {
			if (bname.equals(bdd.getBname())) {
				return bdd;
			}
		}
		if (bname.equals(this.bname)) {
			return this;
		}
		return brokerStatusInfos;
	}

}
