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
import be.biggerbytes.demo.externalizer4j.ArrayWrapper;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by gebruiker on 21/10/14.
 */
public class ArraysSerializable implements Serializable, ArrayWrapper {
    @UniqueObject @Optimize
    public long[] longs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArraysSerializable that = (ArraysSerializable) o;

        if (!Arrays.equals(longs, that.longs)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return longs != null ? Arrays.hashCode(longs) : 0;
    }

    @Override
    public long[] get() {
        return longs;
    }

    @Override
    public void set(long[] longs) {
        this.longs = longs;
    }
}
