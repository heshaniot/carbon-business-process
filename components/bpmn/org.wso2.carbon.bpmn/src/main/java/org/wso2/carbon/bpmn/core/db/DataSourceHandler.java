
/*
 *
 *  * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.wso2.carbon.bpmn.core.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.bpmn.core.exception.BPMNMetaDataTableCreationException;

/**
 * Initializes and starts the BPMN database.
 *
 */

public class DataSourceHandler {

    private static final Log log = LogFactory.getLog(DataSourceHandler.class);
    private Database database = null;


    public void initDataSource(String jndiDataSourceName) throws
                                                          BPMNMetaDataTableCreationException {

        database = new Database(jndiDataSourceName);
        try {
            database.init();
        } catch (Exception e) {
            String errMsg = "BPMN database Initialization failed.";
            log.error(errMsg, e);
            throw new BPMNMetaDataTableCreationException(errMsg, e);
        }
    }

    public void closeDataSource(){
        database.shutdown();
    }
}