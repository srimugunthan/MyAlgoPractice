#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct node{
	int data;
	struct node* ptr;
};
typedef struct node node;
int foo(node *ptr)
{
	node *temp = ptr;
	printf("the value of head %d and it contents %d %d\n",ptr,ptr->data,ptr->ptr);
	ptr = ptr->ptr ;
	free(temp);
	printf("the value of head %d and it contents %d %d\n",temp,temp->data,temp->ptr);
}
int main(){
	node *head ;

	head = (node *) malloc(sizeof(node));
	head -> data = 1;
	
	head ->ptr = (node *) malloc(sizeof(node));
	head->ptr ->data = 2;
	
	head->ptr->ptr =(node *) malloc(sizeof(node));
	head->ptr ->ptr ->data = 3;
	
	head->ptr->ptr ->ptr = NULL;
	printf("the value of head %d and it contents %d %d\n",head,head->data,head->ptr);
	printf("Value of head here is %p\n",head);
	foo(head);
	while(head){
		printf("%d\n",head->data);
		head = head->ptr;
	}
}
