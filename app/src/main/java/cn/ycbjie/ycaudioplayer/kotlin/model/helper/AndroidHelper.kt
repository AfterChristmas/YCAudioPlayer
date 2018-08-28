package cn.ycbjie.ycaudioplayer.kotlin.model.helper

import cn.ycbjie.ycaudioplayer.api.manager.RetrofitWrapper
import cn.ycbjie.ycaudioplayer.kotlin.model.bean.BannerBean
import cn.ycbjie.ycaudioplayer.kotlin.model.bean.NaviBean
import cn.ycbjie.ycaudioplayer.kotlin.model.bean.ProjectListBean
import cn.ycbjie.ycaudioplayer.kotlin.model.bean.TreeBean
import com.mg.axechen.wanandroid.javabean.HomeListBean
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import network.request.RequestApi
import network.response.ResponseBean
import retrofit2.Response


class AndroidHelper private constructor() {

    private var mApiService: RequestApi = RetrofitWrapper
            .getInstance(RequestApi.HOST)
            .create(RequestApi::class.java)


    companion object {
        private var model: AndroidHelper? = null
        // 初始化单例
        fun instance() : AndroidHelper{
            if (model == null) {
                model = AndroidHelper()
            }
            return model as AndroidHelper
        }

    }

    /**
     * 获取主页文章
     */
    fun getHomeList(page: Int): Observable<ResponseBean<HomeListBean>> {
        return mApiService.getHomeList(page)
    }

    /**
     * 获取首页banner数据
     */
    fun getBanner(): Observable<ResponseBean<List<BannerBean>>> {
        return mApiService.getBanner()
    }


    /**
     * 获取知识树
     */
    fun getKnowledgeTree(): Observable<ResponseBean<List<TreeBean>>> {
        return mApiService.getKnowledgeTreeList()
    }


    /**
     * 获取项目树
     */
    fun getProjectTree(): Observable<ResponseBean<List<TreeBean>>> {
        return mApiService.getProjectTree()
    }


    /**
     * 根据项目分类id获取项目列表
     */
    fun getProjectListByCid(page: Int, cid: Int): Observable<ResponseBean<ProjectListBean>> {
        return mApiService.getProjectListByCid(page, cid)
    }


    /**
     * 获取知识体系的文章
     */
    fun getKnowledgeList(page: Int, cid: Int): Observable<ResponseBean<ProjectListBean>> {
        return mApiService.getKnowledgeList(page, cid)
    }

    /**
     * 网址导航
     */
    fun getNaviJson(): Observable<ResponseBean<MutableList<NaviBean>>> {
        return mApiService.getNaviJson()
    }


}
