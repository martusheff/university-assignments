/**
 * Data loader implementation.
 *
 * @author Martusheff, Acuna
 * @version v02.20.2022
 */

#include "DataLoader.h"


struct test_scenario* load_test_data(char* filename) {
    FILE* f;
    f = fopen("data-1.txt", "r");
    struct test_scenario* ts;
    ts = malloc(sizeof (struct test_scenario*));
    fscanf(f, "%d", &ts->page_count);
    fscanf(f, "%d", &ts->frame_count);
    fscanf(f, "%d", &ts->refstr_len);

    for(int i = 0; i < ts->page_count; i++) {
        fscanf(f, "%d", &ts->refstr[i]);
    }
    return ts;
}


