declare global {
    /**
     * 分页查询参数
     */
    interface PageQuery {
        pageNum: number;
        pageSize: number;
    }

    /**
     * 分页响应对象
     */
    interface PageResult<T> {
        /** 数据列表 */
        list: T;
        /** 总数 */
        total: number;
    }

    /**
     * 页签对象
     */
    interface TagView {
        /** 页签名称 */
        name: string;
        /** 页签标题 */
        title: string;
        /** 页签路由路径 */
        path: string;
        /** 页签路由完整路径 */
        fullPath: string;
        /** 页签图标 */
        icon?: string;
        /** 是否固定页签 */
        affix?: boolean;
        /** 是否开启缓存 */
        keepAlive?: boolean;
        /** 路由查询参数 */
        query?: any;
    }

    /**
     * 组件数据源
     */
    interface OptionType {
        /** 值 */
        value: string | number;
        /** 文本 */
        label: string;
        /** 子列表  */
        children?: OptionType[];
    }
}
export { };
