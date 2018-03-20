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
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: gebruiker
 * Date: 29/03/13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class Field15Serializable implements Serializable {
    public Object o1 = "1";
    public Object o2 = "2";
    public Object o3 = "3";
    public Object o4 = "4";
    public Object o5 = "5";
    public Object o6 = "6";
    public Object o7 = "7";
    public Object o8 = "8";
    public Object o9 = "9";
    public Object o10 = "10";
    public Object o11 = "11";
    public Object o12 = "12";
    public Object o13 = "13";
    public Object o14 = "14";
    public Object o15 = "15";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field15Serializable that = (Field15Serializable) o;

        if (o1 != null ? !o1.equals(that.o1) : that.o1 != null) return false;
        if (o10 != null ? !o10.equals(that.o10) : that.o10 != null) return false;
        if (o11 != null ? !o11.equals(that.o11) : that.o11 != null) return false;
        if (o12 != null ? !o12.equals(that.o12) : that.o12 != null) return false;
        if (o13 != null ? !o13.equals(that.o13) : that.o13 != null) return false;
        if (o14 != null ? !o14.equals(that.o14) : that.o14 != null) return false;
        if (o15 != null ? !o15.equals(that.o15) : that.o15 != null) return false;
        if (o2 != null ? !o2.equals(that.o2) : that.o2 != null) return false;
        if (o3 != null ? !o3.equals(that.o3) : that.o3 != null) return false;
        if (o4 != null ? !o4.equals(that.o4) : that.o4 != null) return false;
        if (o5 != null ? !o5.equals(that.o5) : that.o5 != null) return false;
        if (o6 != null ? !o6.equals(that.o6) : that.o6 != null) return false;
        if (o7 != null ? !o7.equals(that.o7) : that.o7 != null) return false;
        if (o8 != null ? !o8.equals(that.o8) : that.o8 != null) return false;
        if (o9 != null ? !o9.equals(that.o9) : that.o9 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = o1 != null ? o1.hashCode() : 0;
        result = 31 * result + (o2 != null ? o2.hashCode() : 0);
        result = 31 * result + (o3 != null ? o3.hashCode() : 0);
        result = 31 * result + (o4 != null ? o4.hashCode() : 0);
        result = 31 * result + (o5 != null ? o5.hashCode() : 0);
        result = 31 * result + (o6 != null ? o6.hashCode() : 0);
        result = 31 * result + (o7 != null ? o7.hashCode() : 0);
        result = 31 * result + (o8 != null ? o8.hashCode() : 0);
        result = 31 * result + (o9 != null ? o9.hashCode() : 0);
        result = 31 * result + (o10 != null ? o10.hashCode() : 0);
        result = 31 * result + (o11 != null ? o11.hashCode() : 0);
        result = 31 * result + (o12 != null ? o12.hashCode() : 0);
        result = 31 * result + (o13 != null ? o13.hashCode() : 0);
        result = 31 * result + (o14 != null ? o14.hashCode() : 0);
        result = 31 * result + (o15 != null ? o15.hashCode() : 0);
        return result;
    }

}
