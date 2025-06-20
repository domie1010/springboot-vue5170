const base = {
    get() {
        return {
            url : "http://localhost:8080/meifaguanli/",
            name: "meifaguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/meifaguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "美发管理系统"
        } 
    }
}
export default base
