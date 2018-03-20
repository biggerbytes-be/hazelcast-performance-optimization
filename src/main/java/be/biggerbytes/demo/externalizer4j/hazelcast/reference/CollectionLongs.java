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

package be.biggerbytes.demo.externalizer4j.hazelcast.reference;

import be.biggerbytes.demo.externalizer4j.CollectionWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by johan on 12/24/14.
 */
public class CollectionLongs implements Serializable, CollectionWrapper<Long> {
    public List<Long> wrappedLongs = new ArrayList<Long>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionLongs that = (CollectionLongs) o;

        if (wrappedLongs != null ? !wrappedLongs.equals(that.wrappedLongs) : that.wrappedLongs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return wrappedLongs != null ? wrappedLongs.hashCode() : 0;
    }

    @Override
    public Collection<Long> get() {
        return wrappedLongs;
    }
}
