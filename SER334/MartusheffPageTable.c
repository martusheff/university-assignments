/**
 * Page table implementation.
 *
 * @author Martusheff, Acuna
 * @version v02.20.2022
 */

#include "PageTable.h"

struct page_table_entry {
    unsigned int data;
};

struct page_table {
    enum replacement_algorithm type;
    int fault_count;
    int page_count;
    int frame_count;
    int verbose;
    struct page_table_entry* entries;
};

struct page_table* page_table_create(int page_count, int frame_count, enum replacement_algorithm algorithm, int verbose) {
    struct page_table *pt;
    pt = malloc(sizeof (struct page_table *));
    pt->page_count = page_count;
    pt->frame_count = frame_count;
    pt->type = algorithm;
    pt->verbose = verbose;
    return pt;
}

void page_table_destroy(struct page_table** pt) {

}

void page_table_access_page(struct page_table *pt, int page) {
    pt->entries = malloc(sizeof( struct page_table_entry*) * pt->page_count);
    pt->entries[page];
}

void page_table_display(struct page_table* pt) {
    printf("\n----Page Table----\n");
    printf("Mode: ");
    switch (pt->type) {
        case FIFO:
            printf("FIFO");
        case LRU:
            printf("LRU");
        case MFU:
            printf("MFU");
    }
    printf("\nPage Faults: %d", pt->fault_count);
    printf("\npage frame | dirty valid");
    for(int i = 0; i < pt->page_count; i++) {
        printf("\n   %d     %d |     0     %d", i, i%3, 1);
    }
}