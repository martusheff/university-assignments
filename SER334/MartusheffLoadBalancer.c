/**
 * Load balancer program.
 *
 * @author Andronick Martusheff
 * @version v02.10.2022
 */

#include "LoadBalancer.h"
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

struct balancer {
    struct host* host;
    struct job_node* head;
    pthread_mutex_t* lock;
    int number_of_requests;
    int batch_size;
};

balancer* balancer_create(int batch_size) {
    pthread_mutex_t lock;
    pthread_mutex_init(&lock, NULL);
    balancer* b = (balancer*)malloc(sizeof (balancer));
    b->head = NULL;
    b->lock = &lock;
    b->number_of_requests = 0;
    b->batch_size = batch_size;
    b->host = host_create();
    return b;
}

void balancer_destroy(balancer** lb) {
    free(*lb);
    *lb = NULL;
}

void balancer_add_job(balancer* lb, int user_id, int data, int* data_return) {

    pthread_mutex_lock(lb->lock);
    printf("LoadBalancer: Received new job from user #%d to process data=%d and store it at %p.\n", user_id, data, data_return);
    lb->number_of_requests++;
    struct job_node* j = (struct job_node*)malloc(sizeof(struct job_node));
    j->data = data;
    j->user_id = user_id;
    j->data_result = data_return;

    j->next = lb->head;
    lb->head = j;

    if(lb->number_of_requests == lb->batch_size) {
        host_request_instance(lb->host, lb->head);
        lb->number_of_requests = 0;
    }
    pthread_mutex_unlock(lb->lock);
}