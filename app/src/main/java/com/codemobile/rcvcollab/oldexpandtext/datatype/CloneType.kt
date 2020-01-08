package com.codemobile.rcvcollab.oldexpandtext.datatype

import com.codemobile.rcvcollab.newexpandtext.ExpandState

data class CloneType(
    var cloneText: String,
    var dataState: ExpandState = ExpandState.Collapsed,
    var focus: Boolean = false
) : BaseDataType