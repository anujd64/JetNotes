package com.example.jetnotes.data

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

class DateConverter{

    @TypeConverter
    fun timeStampFromDate(date: Date):Long{
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timeStamp: Long): Date{
        return Date(timeStamp)
    }

}

class UUIDConverter{
    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }
    @TypeConverter
    fun toUUIDFromString(string: String): UUID {
        return UUID.fromString(string)
    }
}