package com.example.shipright.utils

import java.io.IOException

class ApiException(message: String) : IOException(message)
class NoInternetException(message: String) : IOException(message)
class SessionExpiredException(message: String) : IOException(message)