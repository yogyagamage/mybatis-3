/*
 *    Copyright 2009-2026 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.logging.log4j;

import org.apache.ibatis.logging.Log;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Log4jImpltrace_LoggerlogFikaTest {

  @Test
  void testTrace() {
    Logger mockLogger = Mockito.mock(Logger.class);
    Log logInstance = new Log4jImpl("TestLogger");

    try {
      java.lang.reflect.Field loggerField = Log4jImpl.class.getDeclaredField("log");
      loggerField.setAccessible(true);
      loggerField.set(logInstance, mockLogger);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    logInstance.trace("test message");
  }
}
