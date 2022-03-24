/**
 * Instance host implementation.
 *
 * @author Andronick Martusheff
 * @version v02.10.2022
 */


#include "InstanceHost.h"
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

struct host {
    int num_instances;
    pthread_t *t;
};


pthread_t* create_instance(host *h) {
    return (pthread_t*)malloc(sizeof(pthread_t));
}


host* host_create() {
    host* host = (struct host*)malloc(sizeof(host));
    host->num_instances = 0;
    host->t = create_instance(host);
    return host;
}

void host_destroy(host** h) {
    free(*h);
    *h = NULL;
}

void* squared_runner(void* data) {
    struct job_node* job = (struct job_node*)data;
    while(job != NULL) {
        int *save = job->data_result;
        *save = job->data * job->data;
        job = job->next;
    }
    pthread_exit(NULL);
}

void host_request_instance(host* h, struct job_node* batch) {
    printf("LoadBalancer: Received batch and spinning up new instance.\n");
    pthread_t t;
    pthread_create(&t, NULL, squared_runner, batch);
    pthread_join(t, NULL);
    host_destroy(&h);
}