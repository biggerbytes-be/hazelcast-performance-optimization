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

package be.biggerbytes.demo.externalizer4j;

import be.biggerbytes.demo.externalizer4j.hazelcast.reference.ReferenceBenchmark;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.internal.serialization.impl.DefaultSerializationServiceBuilder;
import com.hazelcast.nio.BufferObjectDataInput;
import com.hazelcast.nio.BufferObjectDataOutput;
import com.hazelcast.spi.serialization.SerializationService;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jparent on 8/12/2014.
 */
public abstract class Benchmark {
    // Optimized data
    protected Collection childSerializable;
    protected Collection childChildSerializable;
    protected Collection field15Serializable;
    protected Collection parentDataSerializable;
    protected Object selfReferencing;
    protected Object serFieldSmall;
    protected Object serFinalField;
    protected Collection arraysSerializable;
//    protected Collection arraysSerializableFilled;

    protected CollectionWrapper<Long> collectionLong;
    protected CollectionWrapper<Long> collectionLongFilled;
    protected CollectionWrapper<Long> collectionLongFilled1;
    protected CollectionWrapper<Long> collectionLongFilled10;
    protected CollectionWrapper<Long> collectionLongFilled100;
    protected CollectionWrapper<Long> collectionLongFilled500;

    protected CollectionWrapper collectionSerializable;
    protected CollectionWrapper collectionSerializableFilled;
    protected CollectionWrapper collectionSerializableFilled1;
    protected CollectionWrapper collectionSerializableFilled10;
    protected CollectionWrapper collectionSerializableFilled100;
    protected CollectionWrapper collectionSerializableFilled500;

//    protected CollectionWrapper collectionSerializableFilled500;

    Random r = new Random();
    private BufferObjectDataOutput out;
    private BufferObjectDataInput in;
    Collection<Long> longs = new ArrayList<>();

    /**
     * Create all the objects for this benchmark
     */
    protected abstract void create();


    @Setup
    public void init() throws IOException, IllegalAccessException {
        create();
        //
        fill(collectionLongFilled1, 1);
        fill(collectionLongFilled10, 10);
        fill(collectionLongFilled100, 100);
        fill(collectionLongFilled500, 500);

    }

    protected String random(String s) {
        return s + String.valueOf(r.nextLong());
    }

    protected Date randomDate() {
        return new Date(r.nextLong());
    }

    protected <T extends Serializable> Collection<T> fillRandom(Supplier<T> s, int cnt, Consumer<T>... t) {
        List<T> l = Stream.generate(s).limit(cnt).collect(Collectors.toList());
        for (Consumer<T> consumer : t) {
            l.stream().forEach(consumer);
        }

        return l;
    }

    void fill(CollectionWrapper<Long> c, int cnt) {
        fill(c.get(), cnt);
    }

    void fill(Collection c, int cnt) {
        for (long i = 0; i < cnt; i++) {
            c.add(new Long(i));
        }
    }

    private List<Long> asList(long... longs) {
        List<Long> r = new ArrayList<Long>();
        for (Long aLong : longs) {
            r.add(new Long(aLong));
        }

        return r;
    }


    @org.openjdk.jmh.annotations.Benchmark
    public void writeChildSerializable() throws IOException {
        io(childSerializable);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeChildChildSerializable() throws IOException {
        io(childChildSerializable);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeField15Serializable() throws IOException {
        io(field15Serializable);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeSelfReferencing() throws IOException {
        io(selfReferencing);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeArraysSerializable() throws IOException {
        io(arraysSerializable);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void arraysSerializable() throws IOException {
        out(arraysSerializable);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeParentDataSerializable() throws IOException {
        io(parentDataSerializable);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeCollectionSerializableFilled() throws IOException {
        io(collectionSerializableFilled);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeCollectionSerializableFilled1() throws IOException {
        io(collectionSerializableFilled1);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeCollectionSerializableFilled10() throws IOException {
        io(collectionSerializableFilled10);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeCollectionSerializableFilled100() throws IOException {
        io(collectionSerializableFilled100);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeCollectionSerializableFilled500() throws IOException {
        io(collectionSerializableFilled500);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void writeCollectionSerializable() throws IOException {
        io(collectionSerializable);
    }

    Blackhole blackhole = new Blackhole();

    SerializationService ss;

    @Setup(Level.Invocation)
    public void setupSerialization() {
        SerializationConfig config = new SerializationConfig();
        config.setEnableSharedObject(false);
        config.setAllowUnsafe(true);
        ss = new DefaultSerializationServiceBuilder()
                .setConfig(config)
//                .setAllowUnsafe(false)
//                .setEnableSharedObject(true)
//                .setUseNativeByteOrder(true)
                .build();
    }

    public void io(Collection c) throws IOException {
        for (Object o : c) {
            io(o);
        }
    }

    public void io(Object o) throws IOException {
        Object t = ss.toObject(ss.toData(o));
        blackhole.consume(t);
    }

    public void out(Collection c) throws IOException {
        for (Object o : c) {
            out(o);
        }
    }

    public void out(Object o) throws IOException {
        blackhole.consume(ss.toData(o));
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName() + ".*")
                .include(ReferenceBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(2)
                .build();

        new Runner(opt).run();
    }

}
