package com.stdio.iptesttask.di

import android.content.Context
import com.stdio.iptesttask.data.ProductDAO
import com.stdio.iptesttask.data.ProductsDB
import com.stdio.iptesttask.data.ProductsRepositoryImpl
import com.stdio.iptesttask.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ProductsDB {
        return ProductsDB.getDatabase(appContext, CoroutineScope(SupervisorJob()))
    }

    @Provides
    @Singleton
    fun provideDao(database: ProductsDB) = database.productsDAO()

    @Singleton
    @Provides
    fun provideRepository(productDAO: ProductDAO) =
        ProductsRepositoryImpl(productDAO) as ProductsRepository
}