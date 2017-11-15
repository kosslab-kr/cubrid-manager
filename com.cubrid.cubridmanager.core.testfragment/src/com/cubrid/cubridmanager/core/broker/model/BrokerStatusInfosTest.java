/*
 * Copyright (C) 2009 Search Solution Corporation. All rights reserved by Search Solution. 
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met: 
 *
 * - Redistributions of source code must retain the above copyright notice, 
 *   this list of conditions and the following disclaimer. 
 *
 * - Redistributions in binary form must reproduce the above copyright notice, 
 *   this list of conditions and the following disclaimer in the documentation 
 *   and/or other materials provided with the distribution. 
 *
 * - Neither the name of the <ORGANIZATION> nor the names of its contributors 
 *   may be used to endorse or promote products derived from this software without 
 *   specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
 * OF SUCH DAMAGE. 
 *
 */
package com.cubrid.cubridmanager.core.broker.model;

import java.util.List;

import junit.framework.TestCase;

/**
 * Test BrokerStatusInfos
 * 
 * @author sq
 * @version 1.0 - 2009-12-30 created by sq
 */
public class BrokerStatusInfosTest extends
		TestCase {
	private BrokerStatusInfos bsi;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		bsi = new BrokerStatusInfos();
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#getTaskName()}
	 * .
	 */
	public void testGetTaskName() {
		assertEquals(bsi.getTaskName(), "getbrokerstatus");
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#getAsInfo()}
	 * .
	 */
	public void testGetAsInfo() {
		assertNotNull(bsi.getAsInfo());
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#addAsInfo(com.cubrid.cubridmanager.core.broker.model.ApplyServerInfo)}
	 * .
	 */
	public void testAddAsInfo() {
		ApplyServerInfo asi = new ApplyServerInfo();
		bsi.addAsInfo(asi);
		List<ApplyServerInfo> list = bsi.getAsInfo();
		assertFalse(list.isEmpty());
		list = null;
		bsi.addAsInfo(asi);
		List<ApplyServerInfo> listNew = bsi.getAsInfo();
		assertFalse(listNew.isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#getJobInfo()}
	 * .
	 */
	public void testGetJobInfo() {
		assertNull(bsi.getJobInfo());
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#addJobInfo(com.cubrid.cubridmanager.core.broker.model.JobInfo)}
	 * .
	 */
	public void testAddJobInfo() {
		JobInfo ji = new JobInfo();
		bsi.addJobInfo(ji);
		bsi.addJobInfo(ji);
		List<JobInfo> list = bsi.getJobInfo();
		assertTrue(!list.isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#getBname()}
	 * .
	 */
	public void testGetBname() {
		bsi.setBname("bname");
		assertEquals(bsi.getBname(), "bname");
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#addBroker()}
	 * .
	 * 
	 */
	public final void testAddBroker() {
		BrokerStatusInfos brokerStatusInfos = new BrokerStatusInfos();
		bsi.addBroker(brokerStatusInfos);
		assertFalse(bsi.getBrokerList().isEmpty());
	}

	/**
	 * Test method for
	 * {@link com.cubrid.cubridmanager.core.broker.model.BrokerStatusInfos#getSubBrokerByName(String bname)}
	 * .
	 * 
	 */
	public final void testGetSubBrokerByNameBname() {
		bsi.getSubBrokerByName(null);
		assertTrue(bsi.getBrokerList().isEmpty());
		BrokerStatusInfos brokerStatusInfos = new BrokerStatusInfos();
		brokerStatusInfos.setBname("brokerName");
		bsi.addBroker(brokerStatusInfos);
		BrokerStatusInfos bdd = bsi.getSubBrokerByName("brokerName");
		assertEquals("brokerName", bdd.getBname());
		bdd = bsi.getSubBrokerByName("aaaa");
		assertNull(bdd.getBname());
	}

}
