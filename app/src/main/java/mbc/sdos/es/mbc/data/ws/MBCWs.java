package mbc.sdos.es.mbc.data.ws;


import mbc.sdos.es.mbc.data.entity.dto.object.BookApi;
import mbc.sdos.es.mbc.data.entity.dto.response.BaseResponseApi;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MBCWs {

    @GET("books.json")
    Call<BaseResponseApi<BookApi>> getBookList();

//  @GET("catalog/store")
//  Call<StoreListResponseDTO> getStoreList(@Query("brandId") String brandId,
//                                          @Query("typeCatalog") Long typeCatalog);
//
//  @GET("catalog/store/{store}")
//  Call<StoreDTO> getStoreDetail(@Path("store") Long id, @Query("brandId") String brandId,
//                                @Query("typeCatalog") Long typeCatalog,
//                                @Query("languageId") Long languageId);
//
//  @GET("catalog/store/{storeId}/{catalogId}/category")
//  Call<CategoryListResponseDTO> getCategoryList(@Path("storeId") Long storeId,
//                                                @Path("catalogId") Long catalogId, @Query("brandId") String brandId,
//                                                @Query("languageId") Long languageId);
//
//  @GET("catalog/store/{storeId}/{catalogId}/category/{categoryId}/product")
//  Call<ProductListResponseDTO> getProductList(@Path("storeId") Long storeId,
//                                              @Path("catalogId") Long catalogId, @Path("categoryId") Long categoryId,
//                                              @Query("brandId") String brandId, @Query("languageId") Long languageId);
//
//  @GET("catalog/store/{storeId}/{catalogId}/category/{categoryId}/product/{productId}/detail")
//  Call<ProductBundleDTO> getProductDetail(@Path("storeId") Long storeId,
//                                          @Path("catalogId") Long catalogId, @Path("categoryId") Long categoryId,
//                                          @Path("productId") Long productId, @Query("brandId") String brandId,
//                                          @Query("languageId") Long languageId);
//
//  @GET("catalog/store/{storeId}/{catalogId}/product/{partNumber}")
//  Call<ProductBundleDTO> getProductDetailByPartnumber(@Path("storeId") Long storeId,
//                                                      @Path("catalogId") Long catalogId, @Path("partNumber") String partNumber,
//                                                      @Query("brandId") String brandId, @Query("languageId") Long languageId);
}
