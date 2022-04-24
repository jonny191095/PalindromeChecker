# PalindromeChecker
Simple Palindrome Checker using Redis caching and h2 file store

## Overview
Application provides a single function - taking an input string and confirming if it's a palindrome or not.

- <b>/palindrome</b> post request takes a request body of "username" and "value". The application will validate the input and then output a boolean value indicating if it is a palindrome.

The application utilises a Redis Cache for rapid access of previously solved inputs. The system also stores the cached values in a h2 file store for non-volatile persistence.
