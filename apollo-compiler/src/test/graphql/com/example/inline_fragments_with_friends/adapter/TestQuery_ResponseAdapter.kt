// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragments_with_friends.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.inline_fragments_with_friends.TestQuery
import com.example.inline_fragments_with_friends.type.Episode
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.Named("Character", ResponseField.Kind.OBJECT),
      responseName = "hero",
      fieldName = "hero",
      arguments = emptyMap(),
      conditions = emptyList(),
      possibleFieldSets = mapOf(
        "Human" to Hero.HumanHero.RESPONSE_FIELDS,
        "Droid" to Hero.DroidHero.RESPONSE_FIELDS,
        "" to Hero.OtherHero.RESPONSE_FIELDS,
      ),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var hero: TestQuery.Data.Hero? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> hero = readObject<TestQuery.Data.Hero>(RESPONSE_FIELDS[0]) { reader ->
            Hero.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        hero = hero
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        Hero.toResponse(writer, value.hero)
      }
    }
  }

  object Hero : ResponseAdapter<TestQuery.Data.Hero> {
    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
      val typename = __typename ?: reader.readString(ResponseField.Typename)
      return when(typename) {
        "Human" -> HumanHero.fromResponse(reader, typename)
        "Droid" -> DroidHero.fromResponse(reader, typename)
        else -> OtherHero.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
      when(value) {
        is TestQuery.Data.Hero.HumanHero -> HumanHero.toResponse(writer, value)
        is TestQuery.Data.Hero.DroidHero -> DroidHero.toResponse(writer, value)
        is TestQuery.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
      }
    }

    object HumanHero : ResponseAdapter<TestQuery.Data.Hero.HumanHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.Named("Float", ResponseField.Kind.OTHER),
          responseName = "height",
          fieldName = "height",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.List(ResponseField.Type.Named("Character",
              ResponseField.Kind.OBJECT)),
          responseName = "friends",
          fieldName = "friends",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to Friend.RESPONSE_FIELDS
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.HumanHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var height: Double? = null
          var friends: List<TestQuery.Data.Hero.HumanHero.Friend?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> height = readDouble(RESPONSE_FIELDS[2])
              3 -> friends = readList<TestQuery.Data.Hero.HumanHero.Friend>(RESPONSE_FIELDS[3]) { reader ->
                reader.readObject<TestQuery.Data.Hero.HumanHero.Friend> { reader ->
                  Friend.fromResponse(reader)
                }
              }
              else -> break
            }
          }
          TestQuery.Data.Hero.HumanHero(
            __typename = __typename!!,
            name = name!!,
            height = height,
            friends = friends
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.HumanHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeDouble(RESPONSE_FIELDS[2], value.height)
        writer.writeList(RESPONSE_FIELDS[3], value.friends) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Friend.toResponse(writer, value)
          }
        }
      }

      object Friend : ResponseAdapter<TestQuery.Data.Hero.HumanHero.Friend> {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type =
                ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named("Episode",
                ResponseField.Kind.OTHER))),
            responseName = "appearsIn",
            fieldName = "appearsIn",
            arguments = emptyMap(),
            conditions = emptyList(),
            possibleFieldSets = emptyMap(),
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.HumanHero.Friend {
          return reader.run {
            var appearsIn: List<Episode?>? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[0]) { reader ->
                  Episode.safeValueOf(reader.readString())
                }
                else -> break
              }
            }
            TestQuery.Data.Hero.HumanHero.Friend(
              appearsIn = appearsIn!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.HumanHero.Friend) {
          writer.writeList(RESPONSE_FIELDS[0], value.appearsIn) { value, listItemWriter ->
            listItemWriter.writeString(value?.rawValue)}
        }
      }
    }

    object DroidHero : ResponseAdapter<TestQuery.Data.Hero.DroidHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.Named("String", ResponseField.Kind.OTHER),
          responseName = "primaryFunction",
          fieldName = "primaryFunction",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.List(ResponseField.Type.Named("Character",
              ResponseField.Kind.OBJECT)),
          responseName = "friends",
          fieldName = "friends",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = mapOf(
            "" to Friend.RESPONSE_FIELDS
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.DroidHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var primaryFunction: String? = null
          var friends: List<TestQuery.Data.Hero.DroidHero.Friend?>? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
              3 -> friends = readList<TestQuery.Data.Hero.DroidHero.Friend>(RESPONSE_FIELDS[3]) { reader ->
                reader.readObject<TestQuery.Data.Hero.DroidHero.Friend> { reader ->
                  Friend.fromResponse(reader)
                }
              }
              else -> break
            }
          }
          TestQuery.Data.Hero.DroidHero(
            __typename = __typename!!,
            name = name!!,
            primaryFunction = primaryFunction,
            friends = friends
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.DroidHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
        writer.writeList(RESPONSE_FIELDS[3], value.friends) { value, listItemWriter ->
          listItemWriter.writeObject { writer ->
            Friend.toResponse(writer, value)
          }
        }
      }

      object Friend : ResponseAdapter<TestQuery.Data.Hero.DroidHero.Friend> {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
                ResponseField.Kind.OTHER)),
            responseName = "id",
            fieldName = "id",
            arguments = emptyMap(),
            conditions = emptyList(),
            possibleFieldSets = emptyMap(),
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.DroidHero.Friend {
          return reader.run {
            var id: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> id = readString(RESPONSE_FIELDS[0])
                else -> break
              }
            }
            TestQuery.Data.Hero.DroidHero.Friend(
              id = id!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.DroidHero.Friend) {
          writer.writeString(RESPONSE_FIELDS[0], value.id)
        }
      }
    }

    object OtherHero : ResponseAdapter<TestQuery.Data.Hero.OtherHero> {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
              ResponseField.Kind.OTHER)),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = emptyList(),
          possibleFieldSets = emptyMap(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.OtherHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              else -> break
            }
          }
          TestQuery.Data.Hero.OtherHero(
            __typename = __typename!!,
            name = name!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.OtherHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
      }
    }
  }
}
