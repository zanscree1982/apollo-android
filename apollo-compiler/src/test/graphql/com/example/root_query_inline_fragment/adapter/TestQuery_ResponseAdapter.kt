// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_inline_fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.root_query_inline_fragment.TestQuery
import com.example.root_query_inline_fragment.type.Episode
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    val typename = __typename ?: reader.readString(ResponseField.Typename)
    return when(typename) {
      "Query" -> QueryData.fromResponse(reader, typename)
      else -> OtherData.fromResponse(reader, typename)
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    when(value) {
      is TestQuery.Data.QueryData -> QueryData.toResponse(writer, value)
      is TestQuery.Data.OtherData -> OtherData.toResponse(writer, value)
    }
  }

  object QueryData : ResponseAdapter<TestQuery.Data.QueryData> {
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
        type = ResponseField.Type.Named("Character", ResponseField.Kind.OBJECT),
        responseName = "hero",
        fieldName = "hero",
        arguments = emptyMap(),
        conditions = emptyList(),
        possibleFieldSets = mapOf(
          "Human" to Hero.HumanHero.RESPONSE_FIELDS,
          "" to Hero.OtherHero.RESPONSE_FIELDS,
        ),
      ),
      ResponseField(
        type = ResponseField.Type.Named("Droid", ResponseField.Kind.OBJECT),
        responseName = "droid",
        fieldName = "droid",
        arguments = mapOf<String, Any?>(
          "id" to 1),
        conditions = emptyList(),
        possibleFieldSets = mapOf(
          "Droid" to Droid.DroidDroid.RESPONSE_FIELDS,
          "" to Droid.OtherDroid.RESPONSE_FIELDS,
        ),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestQuery.Data.QueryData {
      return reader.run {
        var __typename: String? = __typename
        var hero: TestQuery.Data.QueryData.Hero? = null
        var droid: TestQuery.Data.QueryData.Droid? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> hero = readObject<TestQuery.Data.QueryData.Hero>(RESPONSE_FIELDS[1]) { reader ->
              Hero.fromResponse(reader)
            }
            2 -> droid = readObject<TestQuery.Data.QueryData.Droid>(RESPONSE_FIELDS[2]) { reader ->
              Droid.fromResponse(reader)
            }
            else -> break
          }
        }
        TestQuery.Data.QueryData(
          __typename = __typename!!,
          hero = hero,
          droid = droid
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.QueryData) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      if(value.hero == null) {
        writer.writeObject(RESPONSE_FIELDS[1], null)
      } else {
        writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
          Hero.toResponse(writer, value.hero)
        }
      }
      if(value.droid == null) {
        writer.writeObject(RESPONSE_FIELDS[2], null)
      } else {
        writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
          Droid.toResponse(writer, value.droid)
        }
      }
    }

    object Hero : ResponseAdapter<TestQuery.Data.QueryData.Hero> {
      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.QueryData.Hero {
        val typename = __typename ?: reader.readString(ResponseField.Typename)
        return when(typename) {
          "Human" -> HumanHero.fromResponse(reader, typename)
          else -> OtherHero.fromResponse(reader, typename)
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.QueryData.Hero) {
        when(value) {
          is TestQuery.Data.QueryData.Hero.HumanHero -> HumanHero.toResponse(writer, value)
          is TestQuery.Data.QueryData.Hero.OtherHero -> OtherHero.toResponse(writer, value)
        }
      }

      object HumanHero : ResponseAdapter<TestQuery.Data.QueryData.Hero.HumanHero> {
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
            type =
                ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named("Episode",
                ResponseField.Kind.OTHER))),
            responseName = "appearsIn",
            fieldName = "appearsIn",
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
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.QueryData.Hero.HumanHero {
          return reader.run {
            var __typename: String? = __typename
            var name: String? = null
            var appearsIn: List<Episode?>? = null
            var height: Double? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> name = readString(RESPONSE_FIELDS[1])
                2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
                  Episode.safeValueOf(reader.readString())
                }
                3 -> height = readDouble(RESPONSE_FIELDS[3])
                else -> break
              }
            }
            TestQuery.Data.QueryData.Hero.HumanHero(
              __typename = __typename!!,
              name = name!!,
              appearsIn = appearsIn!!,
              height = height
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.QueryData.Hero.HumanHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeString(RESPONSE_FIELDS[1], value.name)
          writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { value, listItemWriter ->
            listItemWriter.writeString(value?.rawValue)}
          writer.writeDouble(RESPONSE_FIELDS[3], value.height)
        }
      }

      object OtherHero : ResponseAdapter<TestQuery.Data.QueryData.Hero.OtherHero> {
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
            TestQuery.Data.QueryData.Hero.OtherHero {
          return reader.run {
            var __typename: String? = __typename
            var name: String? = null
            var appearsIn: List<Episode?>? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> name = readString(RESPONSE_FIELDS[1])
                2 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
                  Episode.safeValueOf(reader.readString())
                }
                else -> break
              }
            }
            TestQuery.Data.QueryData.Hero.OtherHero(
              __typename = __typename!!,
              name = name!!,
              appearsIn = appearsIn!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.QueryData.Hero.OtherHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeString(RESPONSE_FIELDS[1], value.name)
          writer.writeList(RESPONSE_FIELDS[2], value.appearsIn) { value, listItemWriter ->
            listItemWriter.writeString(value?.rawValue)}
        }
      }
    }

    object Droid : ResponseAdapter<TestQuery.Data.QueryData.Droid> {
      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.QueryData.Droid {
        val typename = __typename ?: reader.readString(ResponseField.Typename)
        return when(typename) {
          "Droid" -> DroidDroid.fromResponse(reader, typename)
          else -> OtherDroid.fromResponse(reader, typename)
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.QueryData.Droid) {
        when(value) {
          is TestQuery.Data.QueryData.Droid.DroidDroid -> DroidDroid.toResponse(writer, value)
          is TestQuery.Data.QueryData.Droid.OtherDroid -> OtherDroid.toResponse(writer, value)
        }
      }

      object DroidDroid : ResponseAdapter<TestQuery.Data.QueryData.Droid.DroidDroid> {
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
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.QueryData.Droid.DroidDroid {
          return reader.run {
            var __typename: String? = __typename
            var name: String? = null
            var primaryFunction: String? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> name = readString(RESPONSE_FIELDS[1])
                2 -> primaryFunction = readString(RESPONSE_FIELDS[2])
                else -> break
              }
            }
            TestQuery.Data.QueryData.Droid.DroidDroid(
              __typename = __typename!!,
              name = name!!,
              primaryFunction = primaryFunction
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.QueryData.Droid.DroidDroid) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeString(RESPONSE_FIELDS[1], value.name)
          writer.writeString(RESPONSE_FIELDS[2], value.primaryFunction)
        }
      }

      object OtherDroid : ResponseAdapter<TestQuery.Data.QueryData.Droid.OtherDroid> {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
                ResponseField.Kind.OTHER)),
            responseName = "__typename",
            fieldName = "__typename",
            arguments = emptyMap(),
            conditions = emptyList(),
            possibleFieldSets = emptyMap(),
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.QueryData.Droid.OtherDroid {
          return reader.run {
            var __typename: String? = __typename
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                else -> break
              }
            }
            TestQuery.Data.QueryData.Droid.OtherDroid(
              __typename = __typename!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.QueryData.Droid.OtherDroid) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        }
      }
    }
  }

  object OtherData : ResponseAdapter<TestQuery.Data.OtherData> {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named("String",
            ResponseField.Kind.OTHER)),
        responseName = "__typename",
        fieldName = "__typename",
        arguments = emptyMap(),
        conditions = emptyList(),
        possibleFieldSets = emptyMap(),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestQuery.Data.OtherData {
      return reader.run {
        var __typename: String? = __typename
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            else -> break
          }
        }
        TestQuery.Data.OtherData(
          __typename = __typename!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.OtherData) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    }
  }
}
