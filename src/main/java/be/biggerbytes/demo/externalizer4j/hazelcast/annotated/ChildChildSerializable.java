/*
 * Copyright 2013-2017 Biggerbytes.be
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
 *
 */

package be.biggerbytes.demo.externalizer4j.hazelcast.annotated;


import be.biggerbytes.demo.externalizer4j.Optimize;
import be.biggerbytes.demo.externalizer4j.UniqueObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Johan
 * Date: 25/03/13
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class ChildChildSerializable extends ChildSerializable implements Serializable {
    @UniqueObject
    @Optimize
    public Date childChildDate = new Date();
    @UniqueObject
    SerFieldSmall serFieldSmall;
}
