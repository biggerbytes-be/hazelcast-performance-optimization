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

package be.biggerbytes.demo.externalizer4j.hazelcast.automatic;

import be.biggerbytes.demo.externalizer4j.CollectionWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by johan on 12/24/14.
 */
public class CollectionSerializable implements Serializable, CollectionWrapper<ChildChildSerializable> {
    public List<ChildChildSerializable> collection = new ArrayList<ChildChildSerializable>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionSerializable that = (CollectionSerializable) o;

        if (collection != null ? !collection.equals(that.collection) : that.collection != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return collection != null ? collection.hashCode() : 0;
    }

    @Override
    public Collection<ChildChildSerializable> get() {
        return collection;
    }
}
