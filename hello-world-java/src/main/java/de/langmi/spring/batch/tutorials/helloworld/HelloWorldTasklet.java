/**
 * Copyright 2011 Michael R. Lange <michael.r.lange@langmi.de>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.langmi.spring.batch.tutorials.helloworld;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * This is a Tasklet(step) implementation which prints out a friendly "Hello World!".
 * 
 * In Spring Batch a Taskletstep is a simplified version of a Step,
 * without the chunk-oriented processing.
 *
 * @author Michael R. Lange <michael.r.lange@langmi.de>
 * @see <a href="http://static.springsource.org/spring-batch/reference/html/configureStep.html#taskletStep">TaskletStep</a>
 * @see <a href="http://static.springsource.org/spring-batch/reference/html/domain.html#domainStep">Step</a>
 * @see <a href="http://static.springsource.org/spring-batch/reference/html/configureStep.html#chunkOrientedProcessing">chunk-oriented processing</a>
 */
public class HelloWorldTasklet implements Tasklet {

    /** {@inheritDoc} */
    @Override
    public RepeatStatus execute(StepContribution contribution, 
                                ChunkContext chunkContext) throws Exception {

        // why not using println? because it makes testing harder, *nix and
        // windows think different about new line as in \n vs \r\n
        System.out.print("Hello World!");

        return RepeatStatus.FINISHED;
    }
}
