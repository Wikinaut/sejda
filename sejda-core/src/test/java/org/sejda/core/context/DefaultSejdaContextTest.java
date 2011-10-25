/*
 * Created on 12/mag/2010
 *
 * Copyright 2010 by Andrea Vacondio (andrea.vacondio@gmail.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.sejda.core.context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sejda.core.exception.TaskException;
import org.sejda.core.exception.TaskNotFoundException;
import org.sejda.core.manipulation.ChildTestTaskParameter;
import org.sejda.core.manipulation.TestTaskParameter;
import org.sejda.core.manipulation.model.output.TaskOutput;
import org.sejda.core.manipulation.model.parameter.base.TaskParameters;
import org.sejda.core.manipulation.model.task.Task;

/**
 * @author Andrea Vacondio
 * 
 */
public class DefaultSejdaContextTest {
    private SejdaContext victim;

    @Before
    public void setUp() {
        victim = new DefaultSejdaContext();
    }

    @Test
    public void testGetTaskPositive() throws TaskException {
        Task<? extends TaskParameters> task = victim.getTask(new TestTaskParameter());
        Assert.assertNotNull(task);
    }

    @Test
    public void testGetTaskPositiveNearest() throws TaskException {
        Task<? extends TaskParameters> task = victim.getTask(new ChildTestTaskParameter());
        Assert.assertNotNull(task);
    }

    @Test(expected = TaskNotFoundException.class)
    public void testGetTaskNegative() throws TaskException {
        Task<? extends TaskParameters> task = victim.getTask(new TaskParameters() {

            public TaskOutput getOutput() {
                return null;
            }

            public boolean isOverwrite() {
                return false;
            }
        });
        Assert.assertNotNull(task);
    }
}