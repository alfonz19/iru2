package com.gmail.alfonz19.util;

//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.function.Supplier;

@SuppressWarnings({"squid:S119", "squid:S1172", "unused"})//type variables, unused method parameters, unused constructs.
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Initialize {

    private  Initialize() { }//TODO MMUCHA: lombok.

    public static <T> RootInstanceConfiguration<T> instance(Supplier<T> instanceSupplier) {
        return new RootInstanceConfiguration<>(instanceSupplier);
    }

    public static <T> RootInstanceConfiguration<T> instance(Class<T> instance) {
        return instance(()->{
            try {
                return instance.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);//todo better exception
            }
        });
    }

    public static <ITEM_TYPE, COLLECTION_TYPE extends Collection<ITEM_TYPE>>
    RootCollectionConfiguration<ITEM_TYPE, COLLECTION_TYPE> collection(Class<ITEM_TYPE> clazz, Supplier<COLLECTION_TYPE> collectionSupplier) {
        return new RootCollectionConfiguration<>(clazz, collectionSupplier);
    }



//    public static <ITEM_TYPE> CollectionConfiguration<ITEM_TYPE> set() {
//        return new CollectionConfiguration<ITEM_TYPE>(HashSet::new);
//    }

//    public static <T> RootCollectionConfiguration<List<T>, T> list() {
//        return new RootCollectionConfiguration<>();
//    }
}
