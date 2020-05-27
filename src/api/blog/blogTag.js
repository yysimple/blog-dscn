import {service} from '../../utils/http'

/**
 * 查询所有的博客Tag
 * @returns {*}
 */
export const findAllBlogTags = () => {
    const url = `blogTag/findAllBlogTag`
    return service.get(url)
}
