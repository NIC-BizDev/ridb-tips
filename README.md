# ridb-tips
Ridb Tips

Endpoints:

Get - /event/{ridbId}/tips (Returning: id, ridbId, description, rating, userCreated, ridbType)
Post - /event/tip (Fields: ridbId, description)

Get - /facilityActivity/{ridbId}/tips
Post - /facilityActivity/tip

Get - /permitEntrance/{ridbId}/tips
Post - /permitEntrance/tip

Get - /recreationAreaActivity/{ridbId}/tips
Post - /recreationAreaActivity/tip

Get - /tour/{ridbId}/tips
Post - /tour/tip

Post - /tip/{tipId}/upvote
Post - /tip/{tipId}/downvote