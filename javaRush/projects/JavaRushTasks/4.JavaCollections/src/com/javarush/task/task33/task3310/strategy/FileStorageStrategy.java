package com.javarush.task.task33.task3310.strategy;

/**
 * Created by blaec on 15\07\17.
 */
public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private long maxBucketSize;

    public int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int hash, int lenght) {
        return hash & (lenght - 1);
    }
    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }


    // Transfer the table (adjust to new capacity)
    public void transfer(FileBucket[] newTable) {

        // loop all buckets in table
        for (int i = 0; i < table.length; i++) {

            // skip if bucket is empty [null]
            if (table[i] == null) continue;

            // Get entry object from the bucket
            Entry entry = table[i].getEntry();

            // Proceed while entry not empty [null]
            while (entry != null) {

                // Let next Entry be nextEntry and set newIndex
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);

                // If newIndex bucket in new table is null - set Entry's next field to null and initialize the bucket with new FileBucket
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();

                // set next entry to newIndex entry
                } else {
                    entry.next = newTable[newIndex].getEntry();
                }

                // put Entry to newIndex bucket and set entry be equal to entry.next
                newTable[newIndex].putEntry(entry);
                entry = next;
            }

            // remove temp file
            table[i].remove();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public Entry getEntry(Long key) {

        // get hash and index by the key
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        // if bucket not null
        if (table[index] != null) {

            // Get entry from bucket
            Entry entry = table[index].getEntry();

            // Proceed while entry is not null
            while (entry != null) {

                // Return entry for the same key
                if (entry.getKey().equals(key)) {
                    return entry;
                }

                // move to next Entry
                entry = entry.next;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {

        // loop all buckets in table
        for (int i = 0; i < table.length; i++) {

            // skip if bucket is null
            if (table[i] == null)
                continue;

            // get entry from file (bucket)
            Entry entry = table[i].getEntry();

            // loop while entry not empty
            while (entry != null) {

                // oompare values, and if match - exit
                if (entry.value.equals(value))
                    return true;

                // move to next entry
                entry = entry.next;
            }
        }
        return false;
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {

        // get entry from bucket
        Entry entry = table[bucketIndex].getEntry();

        // put to this bucket new entry, when existing one is set to next entry
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));

        // adjust size
        size++;

        // double bucket number if size got to its limit
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {

        // create new bucket
        table[bucketIndex] = new FileBucket();

        // put entry to this bucket when next entry set to null
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));

        // adjust size variable
        size++;
    }
    @Override
    public void put(Long key, String value) {

        // create hash and get index for the entry
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        // if bucket exist
        if (table[index] != null) {

            // get entry from file
            Entry entry = table[index].getEntry();

            // loop the bucket while entry is not null
            while (entry != null) {

                // if key is the same, set the value be equal to sent value and exit loop
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }

                // check next entry
                entry = entry.next;
            }

            // add entry
            addEntry(hash, key, value, index);
        } else {

            // create new entry
            createEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value) {

        // loop the table
        for (int i = 0; i < table.length; i++) {

            // skip if bucket is emtpy
            if (table[i] == null)
                continue;

            // get entry from the bucket
            Entry entry = table[i].getEntry();

            // loop the entry while it's not emty
            while (entry != null) {

                // if matching value found - return the key
                if (entry.value.equals(value))
                    return entry.key;

                // move to next entry
                entry = entry.next;
            }
        }

        // return 0 (no key found)
        return 0L;
    }

    @Override
    public String getValue(Long key) {

        // get entry by key from bucket
        Entry entry = getEntry(key);

        // return value if entry's not empty
        if (entry != null)
            return entry.value;

        // return null if nothing found
        return null;
    }
}
