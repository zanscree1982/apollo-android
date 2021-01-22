// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_friends_connection

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.fragment_friends_connection.adapter.TestQuery_ResponseAdapter
import com.example.fragment_friends_connection.fragment.HeroDetails
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery : Query<TestQuery.Data> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): String = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> = TestQuery_ResponseAdapter
  override fun responseFields(): Array<ResponseField> = TestQuery_ResponseAdapter.RESPONSE_FIELDS
  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    /**
     * A character from the Star Wars universe
     */
    interface Hero {
      val __typename: String

      interface Character : Hero, HeroDetails {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * The friends of the character exposed as a connection with edges
         */
        override val friendsConnection: FriendsConnection

        /**
         * A connection object for a character's friends
         */
        interface FriendsConnection : HeroDetails.FriendsConnection {
          /**
           * The total number of friends
           */
          override val totalCount: Int?

          /**
           * The edges for each of the character's friends.
           */
          override val edges: List<Edge?>?

          /**
           * An edge object for a character's friends
           */
          interface Edge : HeroDetails.FriendsConnection.Edge {
            /**
             * The character represented by this friendship edge
             */
            override val node: Node?

            /**
             * A character from the Star Wars universe
             */
            interface Node : HeroDetails.FriendsConnection.Edge.Node {
              /**
               * The name of the character
               */
              override val name: String
            }
          }
        }
      }

      data class CharacterHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * The friends of the character exposed as a connection with edges
         */
        override val friendsConnection: FriendsConnection
      ) : Hero, Character, HeroDetails {
        /**
         * A connection object for a character's friends
         */
        data class FriendsConnection(
          /**
           * The total number of friends
           */
          override val totalCount: Int?,
          /**
           * The edges for each of the character's friends.
           */
          override val edges: List<Edge?>?
        ) : Character.FriendsConnection, HeroDetails.FriendsConnection {
          /**
           * An edge object for a character's friends
           */
          data class Edge(
            /**
             * The character represented by this friendship edge
             */
            override val node: Node?
          ) : Character.FriendsConnection.Edge, HeroDetails.FriendsConnection.Edge {
            /**
             * A character from the Star Wars universe
             */
            data class Node(
              /**
               * The name of the character
               */
              override val name: String
            ) : Character.FriendsConnection.Edge.Node, HeroDetails.FriendsConnection.Edge.Node
          }
        }
      }

      data class OtherHero(
        override val __typename: String
      ) : Hero

      companion object {
        fun Hero.asCharacter(): Character? = this as? Character

        fun Hero.heroDetails(): HeroDetails? = this as? HeroDetails
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "ac2255616c64981e4eba18305a14af23c1fb8c934e47ee23fa80f3712e901a18"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  hero {
          |    __typename
          |    ...HeroDetails
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  name
          |  friendsConnection {
          |    totalCount
          |    edges {
          |      node {
          |        name
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "TestQuery"
  }
}
