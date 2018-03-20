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

import be.biggerbytes.demo.externalizer4j.ArrayWrapper;
import be.biggerbytes.demo.externalizer4j.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;

/**
 * Created by johan on 23/07/17.
 */
@State(Scope.Thread)
public class ReferenceBenchmark extends Benchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ReferenceBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .measurementIterations(10)
                .build();

        new Runner(opt).run();
    }

    @Override
    protected void create() {
        collectionLong = new CollectionLongs();
        collectionLongFilled1 = new CollectionLongs();
        collectionLongFilled10 = new CollectionLongs();
        collectionLongFilled100 = new CollectionLongs();
        collectionLongFilled500 = new CollectionLongs();
        //
        parentDataSerializable = fillRandom(ParentDataSerializable::new, 100,
                p -> p.d = randomDate(),
                p -> p.string = random("e")
        );
        //
        childSerializable = fillRandom(ChildSerializable::new, 100,
                c -> c.d = randomDate(),
                c -> c.string = random("p"),
                (ChildSerializable c) -> c.d = randomDate(),
                (ChildSerializable c) -> c.childString = random("child")
        );
        //
        childChildSerializable = fillRandom(ChildChildSerializable::new, 100,
                c -> c.d = randomDate(),
                c -> c.string = random("p"),
                c -> c.d = randomDate(),
                c -> c.childString = random("child"),
                (ChildChildSerializable c) -> c.childChildDate = randomDate()
        );
        //
        field15Serializable = fillRandom(Field15Serializable::new, 100,
                (Field15Serializable p) -> p.o1 = random("f15"),
                (Field15Serializable p) -> p.o2 = random("f15"),
                (Field15Serializable p) -> p.o3 = random("f15"),
                (Field15Serializable p) -> p.o4 = random("f15"),
                (Field15Serializable p) -> p.o5 = random("f15"),
                (Field15Serializable p) -> p.o6 = random("f15"),
                (Field15Serializable p) -> p.o7 = random("f15"),
                (Field15Serializable p) -> p.o8 = random("f15"),
                (Field15Serializable p) -> p.o9 = random("f15"),
                (Field15Serializable p) -> p.o10 = random("f15"),
                (Field15Serializable p) -> p.o11 = random("f15"),
                (Field15Serializable p) -> p.o12 = random("f15"),
                (Field15Serializable p) -> p.o13 = random("f15"),
                (Field15Serializable p) -> p.o14 = random("f15"),
                (Field15Serializable p) -> p.o15 = random("f15"));
        selfReferencing = new SelfReferencing();
        serFieldSmall = new SerFieldSmall();
        serFinalField = new SerFinalField();

        arraysSerializable = fillRandom(ArraysSerializable::new, 100,
                a -> a.longs = new long[200]
        );

        collectionSerializable = new CollectionSerializable();
        collectionSerializableFilled = new CollectionSerializable();
        collectionSerializableFilled.get().addAll(createCCS(0));
        //
        collectionSerializableFilled1 = new CollectionSerializable();
        collectionSerializableFilled1.get().addAll(createCCS(1));
        //
        collectionSerializableFilled10 = new CollectionSerializable();
        collectionSerializableFilled10.get().addAll(createCCS(10));
        //
        collectionSerializableFilled100 = new CollectionSerializable();
        collectionSerializableFilled100.get().addAll(createCCS(100));
        //
        collectionSerializableFilled500 = new CollectionSerializable();
        collectionSerializableFilled500.get().addAll(createCCS(500));
    }

    private Collection<ChildChildSerializable> createCCS(int cnt) {
        return fillRandom(ChildChildSerializable::new, cnt,
                        c -> c.d = randomDate(),
                        c -> c.string = random("p"),
                        c -> c.d = randomDate(),
                        c -> c.childString = random("child"),
                        (ChildChildSerializable c) -> c.childChildDate = randomDate()
                );
    }
}
