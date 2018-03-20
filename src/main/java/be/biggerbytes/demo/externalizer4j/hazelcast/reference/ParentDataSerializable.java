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

import be.biggerbytes.demo.externalizer4j.RandomInit;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Johan
 * Date: 25/03/13
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public class ParentDataSerializable implements Serializable {
    public String string = "s";
    public long l = 1L;
    public Date d = new Date();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentDataSerializable that = (ParentDataSerializable) o;

        if (l != that.l) return false;
        if (d != null ? !d.equals(that.d) : that.d != null) return false;
        if (string != null ? !string.equals(that.string) : that.string != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = string != null ? string.hashCode() : 0;
        result = 31 * result + (int) (l ^ (l >>> 32));
        result = 31 * result + (d != null ? d.hashCode() : 0);
        return result;
    }

}
