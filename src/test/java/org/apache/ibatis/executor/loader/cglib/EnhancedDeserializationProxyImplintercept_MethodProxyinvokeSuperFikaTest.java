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
package org.apache.ibatis.executor.loader.cglib;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.cglib.proxy.MethodProxy;

import org.apache.ibatis.executor.loader.ResultLoaderMap;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnhancedDeserializationProxyImplintercept_MethodProxyinvokeSuperFikaTest {

  @Test
  void testIntercept() throws Throwable {
    // Create mock dependencies for constructor
    Class<?> type = Object.class;
    Map<String, ResultLoaderMap.LoadPair> unloadedProperties = new HashMap<>();
    ObjectFactory objectFactory = Mockito.mock(ObjectFactory.class);
    List<Class<?>> constructorArgTypes = new ArrayList<>();
    List<Object> constructorArgs = new ArrayList<>();

    // Create instance using private constructor via reflection
    Class<?> proxyClass = Class
        .forName("org.apache.ibatis.executor.loader.cglib.CglibProxyFactory$EnhancedDeserializationProxyImpl");
    java.lang.reflect.Constructor<?> constructor = proxyClass.getDeclaredConstructor(Class.class, Map.class,
        ObjectFactory.class, List.class, List.class);
    constructor.setAccessible(true);
    Object proxyInstance = constructor.newInstance(type, unloadedProperties, objectFactory, constructorArgTypes,
        constructorArgs);

    // Prepare parameters for intercept method
    Object enhanced = new Object();
    Method method = Object.class.getMethod("toString");
    Object[] args = new Object[0];
    MethodProxy methodProxy = Mockito.mock(MethodProxy.class);

    // Configure methodProxy.invokeSuper to return something that is NOT AbstractSerialStateHolder
    Mockito.when(methodProxy.invokeSuper(Mockito.any(), Mockito.any())).thenReturn(new Object());

    // Call the intercept method
    java.lang.reflect.Method interceptMethod = proxyClass.getDeclaredMethod("intercept", Object.class, Method.class,
        Object[].class, MethodProxy.class);
    interceptMethod.invoke(proxyInstance, enhanced, method, args, methodProxy);
  }
}
