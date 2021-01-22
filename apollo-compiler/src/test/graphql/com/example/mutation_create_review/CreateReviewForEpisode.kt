// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.mutation_create_review

import com.apollographql.apollo.api.Mutation
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.mutation_create_review.adapter.CreateReviewForEpisode_ResponseAdapter
import com.example.mutation_create_review.type.Episode
import com.example.mutation_create_review.type.ReviewInput
import java.util.Date
import kotlin.Any
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.jvm.Transient

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
internal data class CreateReviewForEpisode(
  val ep: Episode,
  val review: ReviewInput
) : Mutation<CreateReviewForEpisode.Data> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["ep"] = this@CreateReviewForEpisode.ep
      this["review"] = this@CreateReviewForEpisode.review
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        writer.writeString("ep", this@CreateReviewForEpisode.ep.rawValue)
        writer.writeObject("review", this@CreateReviewForEpisode.review.marshaller())
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

  override fun name(): String = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> = CreateReviewForEpisode_ResponseAdapter
  override fun responseFields(): Array<ResponseField> =
      CreateReviewForEpisode_ResponseAdapter.RESPONSE_FIELDS
  /**
   * The mutation type, represents all updates we can make to our data
   */
  data class Data(
    val createReview: CreateReview?
  ) : Operation.Data {
    /**
     * Represents a review for a movie
     */
    data class CreateReview(
      /**
       * The number of stars this review gave, 1-5
       */
      val stars: Int,
      /**
       * Comment about the movie
       */
      val commentary: String?,
      /**
       * for test purpose only
       */
      val listOfListOfString: List<List<String>>?,
      /**
       * for test purpose only
       */
      val listOfListOfEnum: List<List<Episode>>?,
      /**
       * for test purpose only
       */
      val listOfListOfCustom: List<List<Date>>?,
      /**
       * for test purpose only
       */
      val listOfListOfObject: List<List<ListOfListOfObject>>?
    ) {
      /**
       * A character from the Star Wars universe
       */
      data class ListOfListOfObject(
        /**
         * The name of the character
         */
        val name: String
      )
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "b333ec8237cdc346478f07c98169eeb782c4afac1a0a8b94c62dfbcb27275b21"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |mutation CreateReviewForEpisode(${'$'}ep: Episode!, ${'$'}review: ReviewInput!) {
          |  createReview(episode: ${'$'}ep, review: ${'$'}review) {
          |    stars
          |    commentary
          |    listOfListOfString
          |    listOfListOfEnum
          |    listOfListOfCustom
          |    listOfListOfObject {
          |      name
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: String = "CreateReviewForEpisode"
  }
}
