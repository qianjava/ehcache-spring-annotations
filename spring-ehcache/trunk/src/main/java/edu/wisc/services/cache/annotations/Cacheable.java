/*
 * Created on Apr 29, 2005
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2005 the original author or authors.
 */
package edu.wisc.services.cache.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * JDK 1.5+ annotation that identifies the methods which return value should be
 * stored in the cache.
 * </p>
 *
 * @author Alex Ruiz
 */
@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Cacheable {
    /**
     * The name of the cache to use
     */
    String cacheName();

    /**
     * If a EhCache {@link net.sf.ehcache.constructs.blocking.BlockingCache} wrapper should be used
     */
    boolean blocking() default false;
    
    /**
     * The name of the {@link CacheKeyGenerator} to use.
     */
    String keyGeneratorName() default "cacheKeyGenerator";
    
    /**
     * The name of the cache to use for storing exceptions thrown by the advised method
     */
    String exceptionCacheName() default "";
}