package com.example.mangethemeapp

/*
* Side effect-> it is a way to control the execution of composable function.
*
* LaunchedEffect-> it is a way to create a coroutineScope to launch a coroutine.
*           When configuration is changed,the launchedEffect dispose the coroutineScope
*           and cancel all coroutines.After That new object of coroutineScope is created.
*/

/* Drawbacks of LaunchedEffect:-
*   1. We can not launch coroutine independently in this scope on an event(i.e click of a button).
*   2. we can not manage coroutine inside launchedEffect coroutineScope.
*   3.LaunchedEffect runs on initial composition only.
*
* */

/*
* RememberCoroutineScope->
* */