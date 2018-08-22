# recital-planner
The purpose of this application is to make it easier to decide the order in which pieces should be performed in a dance recital.

## Eventual Plan:
The application will be able to automatically generate a run order subject to various constraints such as:
* not allowing pieces that contain the same dancers to be consecutive
* minimizing quick changes
* the user should be able to specify more constraints, such as not having too many solos in a row

## MVP:
Preliminary functions:
* given a user specified proposed run order, the application should be able to identify potential conflicts


## Classes:

### Model
* Dance
* Conflict
* RunOrder

### View
* Input
* Output

### Controller