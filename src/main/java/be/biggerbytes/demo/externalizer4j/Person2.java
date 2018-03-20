/*
 * Copyright 2013-2018 Biggerbytes.be
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

package be.biggerbytes.demo.externalizer4j;

import java.util.Date;

public class Person2 {
    String firstName;
    String lastName;
    Date birthDay;

    public Person2(String first, String last, Date date) {
        firstName = first;
        lastName = last;
        birthDay = date;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person2 person = (Person2) o;

        String firstName = this.firstName;
        String lastName = this.lastName;
        Date birthDay = this.birthDay;

        String firstName2 = person.firstName;
        String lastName2 = person.lastName;
        Date birthDay2 = person.birthDay;

        if (firstName != null ? !firstName.equals(firstName2) : firstName2 != null) return false;
        if (lastName != null ? !lastName.equals(lastName2) : lastName2 != null) return false;
        return birthDay != null ? birthDay.equals(birthDay2) : birthDay2 == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        return result;
    }
}
