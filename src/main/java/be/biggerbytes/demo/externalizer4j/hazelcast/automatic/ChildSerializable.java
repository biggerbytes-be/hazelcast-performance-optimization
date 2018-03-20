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

/**
 * Created with IntelliJ IDEA.
 * User: Johan
 * Date: 25/03/13
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class ChildSerializable extends ParentDataSerializable {
    public String childString  = "";
    short aShort;
    char aChar;

/*    public void writeExternal(ObjectOutput out) throws IOException {
        super.equals(out);
        byte status = 0;
        if (this.childString != null)
            status += 1;
        out.writeByte(status);
        if (this.childString != null)
            out.writeUTF(this.childString);
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        byte status = in.readByte();
        if ((status & 0x1) != 0)
            this.childString = in.readUTF();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildSerializable that = (ChildSerializable) o;

        if (childString != null ? !childString.equals(that.childString) : that.childString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return childString != null ? childString.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ChildKryoSerializable{" +
                "childString='" + childString + '\'' +
                '}';
    }
}
